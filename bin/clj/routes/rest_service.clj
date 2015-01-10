(ns routes.rest-service
  (:require [compojure.core :refer :all]
            [liberator.core :refer [defresource resource request-method-in]]
            [cheshire.core :refer :all]
            [chess2.chessboard :refer :all]))

(def auth-username (ref #{"tihi"}))
(contains? @auth-username "tihi")

(defresource hello-test
  :handle-ok "Hello world!"
  :etag "fixed-etag"
  :available-media-types ["text/plain"])

(def data (ref init-pos))

(defresource login
  :allowed-methods [:post]
  :malformed? (fn [context]
               (let [username (get-in context [:request :params "username"])]
                (not (contains? auth-username username))))
  :handle-malformed (generate-string {:success "no"})     
  :handle-created (generate-string {:id "" :success "yes"})
  :available-media-types ["application/json"]
 )

(defresource new-game
  :allowed-methods [:post]
  :malformed? (fn [context]
               (let [username (get-in context [:request :params "username"])]
                (not (contains? auth-username username))))
  :handle-malformed (generate-string {:success "no"})     
  :handle-created (generate-string {:id "" :success "yes" :chessboard @data})
  :available-media-types ["application/json"])

(defresource move)
