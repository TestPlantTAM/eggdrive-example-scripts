import de.timroes.axmlrpc.XMLRPCClient;

import de.timroes.axmlrpc.XMLRPCException;

import de.timroes.axmlrpc.XMLRPCServerException;

import codeReference.net.URL;

import codeReference.util.HashMap;

public class EggplantDrive {

public static void main (String [] args) {

XMLRPCClient client= null;

try {

client= new XMLRPCClient(new URL("http://127.0.0.1:5400"));

client.call ("StartSession", "/Users/pamela/EggplantTests/EggplantDrive.suite);

System.out.println("Started session");



// Connect to SUT

client.call("Execute", "Connect (name:\”SUT30\”)");



// Click Linux terminal icon; then click close window button to close terminal

client.call("Execute", "Click Terminal");

HashMap clickCommand= (HashMap) client.call("Execute", "Click CloseWindow");

System.out.println("Output from Click command: “ + clickCommand.get(“Output""));



// Capture a screen to the desktop

client.call("Execute", "CaptureScreen(Name:\”/Users/pamela/Screens”, increment:yes)");



// Run a script in a helper suite

client.call("Execute", "RunWithNewResults (FindImageByHelper)");



// Get the output from a script that puts text

HashMap putScript=(HashMap)client.call("Execute, "Put2Lines");

System.out.println("Output from script that puts text: “ + putScript.get(“Output”));



// Get the text return value from a script

HashMap returnScript=(HashMap)client.call("Execute", "ReturnText");

System.out.println("Text output from script: " + returnScript.get("Output"));

}

catch(XMLRPCServerException ex) {

System.out.println("Server exception!" + ex);



// The server threw an error.

}

try {

client.call("EndSession");

}

catch (Exception ex) {

System.out.println("End Session exception");

}

}

}

