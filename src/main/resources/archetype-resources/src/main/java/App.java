package ${package};

import java.io.*;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import org.json.JSONObject;


public class App implements RequestStreamHandler {


    /**
     * Handles a Lambda Function request
     * @param input The Lambda Function input stream
     * @param output The Lambda function output stream
     * @param context The Lambda execution environment context object.
     * @throws IOException
     */

    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
        JSONObject json = readInput(input);
        System.out.println(json.toString());
    }

    private JSONObject readInput(InputStream inputStream) throws IOException {
        BufferedReader bR = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        StringBuilder responseStrBuilder = new StringBuilder();
        while ((line = bR.readLine()) != null) {
            responseStrBuilder.append(line);
        }
        inputStream.close();
        System.out.println(responseStrBuilder.toString());
        JSONObject result = new JSONObject(responseStrBuilder.toString());

        return result;
    }
}
