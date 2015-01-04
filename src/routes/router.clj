(ns routes.router
    (:use compojure.core)
    (:use [ring.middleware.params :only [wrap-params]])
    (:use [ring.adapter.jetty :only [run-jetty]])
    (:require [compojure.route :as route])
    (:require [routes.home :as home])
    (:require [routes.page-not-found :as not-found])
    (:require [routes.game-rules :as rules])
    (:require [routes.multiplayer-offline :as offline])
    )

(defroutes app-routes
  ;setting home page to start first
  (GET "/" [] (home/home-page))
  ;page for game rules
  (GET "/game_rules" [] (rules/game-rules-page))
  ;page for multiplayer offline game
  (GET "/multiplayer-offline" [] (offline/offline-game))
  ;adding loading resources folder
  (route/resources "/")
  ;routing to page not found 
  (route/not-found (not-found/page-not-found))
  )

(def app (wrap-params app-routes))
