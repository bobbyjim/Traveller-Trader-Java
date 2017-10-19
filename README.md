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
* Automatically loads and unloads freight and passengers at each stop.
* Cargo rules working (via CargoBuilder and TradeBuilder).

# TO DO
* Persist player data (JSON).
* Add RESTful API: 
  * /playerID                   ; status
  * /playerID/save              ; save player data
  * /playerID/jump/<hex>        ; jump to hex
  * /playerID/buyCargo/<tons>   ; buy speculative cargo
  * /playerID/sellCargo/<tons>  ; sell speculative cargo
  * /register/playerID          ; register new player
* Add "remote" client for computer-controlled ships (connects through API).
* Improve the trade infrastructure.
* Credit player with freight and passengers.
* Add refueling options.
* Add peer-to-peer communication options.
* Change MapFactory to return a "MapDataSource" object.
* MapDataSource is "backed" by a resource based on factory param (e.g. "TravellerMap").
* MapDataSource also manages a (JSON? serialized objects?) cache of previously collected data.  This cache is checked first.
* Client should use a Location Manager to get/set persisted location (which later should query TraderServer).
* ...and more.
