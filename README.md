# Trader
Traveller5 trade engine

# Source
100% Java

# Synopsis
Run the "TraderClient" class from the command line.  You'll start at Regina with a Jump-2 ship and unlimited fuel.

# Status
* Pulls data from TravellerMap.
* Displays worlds within some number of parsecs from the current location.
* Enter the world's list number to jump there.

# TO DO
* Change MapFactory to return a "MapDataSource" object.
* MapDataSource is "backed" by a resource based on factory param (e.g. "TravellerMap").
* MapDataSource also manages a (JSON? serialized objects?) cache of previously collected data.  This cache is checked first.
* Build out the trade infrastructure!
* Client should use a Location Manager to get/set persisted location (which later should query TraderServer).
* ...and more.
