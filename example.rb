require "xmlrpc/client"



# Make an object to represent the XML-RPC server.

server = XMLRPC::Client.new("192.168.3.102",nil,5400)



# try to end any existing session

begin

result = server.call("EndSession")

puts result

rescue



# doesn't really matter if above failed -- no action required

end



# Call the remote server and start a session

result = server.call("StartSession", "c:\\Users\\Support\\Documents\\testing.suite")

puts result



# Establish a connection from eggPlant to a SUT

result = server.call("Execute", "Connect (serverID:\"192.168.3.128\", password:\"eggplanet\")")

output = result["Output"]



# see what the result of the moveto was

puts "MoveTo output: #{output}"



# Execute a moveto command with an existing image

result = server.call("Execute", "MoveTo ChromeShortcut")

output = result["Output"]



# see what the result of the moveto was

puts "MoveTo output: #{output}"



# Execute a script that returns a text value

result = server.call("Execute", "Run DriveTest")

output = result["Result"]



# see what the result returned by the script was

puts "Script output: #{output}"



# End the remote session

result = server.call("EndSession")

puts result