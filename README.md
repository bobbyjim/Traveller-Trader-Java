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
  * Player ID is in JSON body of most things, except GETs.
  * GET /v1/<playerID>             ; player status
  * PUT /v1/ship/<hex>             ; jump to hex
  * CREATE /v1/passengers/high     ; load ship with high passengers (etc)
  * PUT /v1/passengers             ; get passenger counts
  * DELETE /v1/passengers          ; unload all passengers
  * CREATE /v1/cargo/<tons>        ; buy speculative cargo
  * PUT /v1/cargo/<tons>           ; get speculative cargo buy/sell price?
  * DELETE /v1/cargo/<tons>        ; sell speculative cargo
  * CREATE /v1/player/<playerID>   ; create a new player
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
