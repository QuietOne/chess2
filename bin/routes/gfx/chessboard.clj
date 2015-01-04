(ns routes.gfx.chessboard
  (use chess2.chessboard)
  (use chess2.figure)
  ;(:require [reagent.core :as reagent :refer [atom]])
  )

(defn chess-field []
  (let [count (atom 0)]
   [:input {:type "button" :value @count
            :on-click #(swap! count inc)}]))

(defn chess-row []
  (for [x (range 8)] (chess-field)))