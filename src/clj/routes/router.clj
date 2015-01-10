(ns routes.router
    (:use compojure.core)
    (:use [ring.middleware.params :only [wrap-params]])
    (:use [ring.adapter.jetty :only [run-jetty]])
    (:require [compojure.route :as route]
              [routes.home :as home]
              [routes.page-not-found :as not-found]
              [routes.game-rules :as rules]
              [routes.multiplayer-offline :as offline]
              [routes.rest-service :as rest-service]
              [liberator.core :refer [defresource resource request-method-in]]
              [noir.session :as session]
              [ring.middleware.session.memory :refer [memory-store]]))

(defroutes app-routes
  ;setting home page to start first
  (GET "/" [] (home/home-page))
  ;page for game rules
  (GET "/game_rules" [] (rules/game-rules-page))
  ;page for multiplayer offline game
  (GET "/multiplayer-offline" [] (offline/offline-game))
  ;rest methods
  (ANY "/test" request rest-service/hello-test)
  (ANY "/login" request rest-service/login)
  ;(ANY "/new-game" request rest-service/new-game)
  ;(ANY "/move" request rest-service-move)
  
  ;adding loading resources folder
  (route/resources "/")
  ;routing to page not found 
  (route/not-found (not-found/page-not-found))
  
  )

(def app (-> (wrap-params app-routes)
           (session/wrap-noir-session {:store (memory-store)})))