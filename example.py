
import xmlrpclib



# connect to the eggPlant instance

server = xmlrpclib.ServerProxy("http://127.0.0.1:5400")



# start the session

server.startsession("/path/to/my/suite")



# connect eggPlant to the SUT

server.execute("connect serverId:\"192.168.1.34\", password:\"mypass\"")



# run whatever eggPlant code you need/want to run

server.execute("put \"my interesting string\"")

server.execute("click \"someImage\"")



# end the session

server.endsession("")