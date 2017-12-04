# Trader
Interstellar merchant simulation. Carry passengers and cargo to other worlds!

# Source
100% Java

# Synopsis
Run the "worlds.Trader" class from the command line.  You'll start at Regina, a world with reasonable
 interstellar commercial value.  You play by moving your ship to other worlds; currently, the simulator
 automatically takes on and drops off passengers and freight, and calculates local cargo prices.

# Status
* "Star chart" map data is pulled from TravellerMap.com.
* Nearby worlds are listed.
* Enter the world's list number to jump there.
* Your data is persisted in a serialized Java object.
* An early REST API lets you get your status and set your destination.

# REST calls
* http://localhost:2244/v0/ship/<name> - returns status
* http://localhost:2244/v0/ship/<name>/<destination> - sets destination

# TO DO
* Expand REST calls for payload management and player interactions.
* Add "remote" client for computer-controlled ships (connects through API).
* Credit player with freight and passengers.
* Add refueling options.
* Add communication routing between clients.
* More.
