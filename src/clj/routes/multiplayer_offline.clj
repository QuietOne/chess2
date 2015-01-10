(ns routes.multiplayer-offline
  (:use routes.template)
  (:use hiccup.element)
  (:use hiccup.page)
  )

(defn offline-game []
 (layout "Chess 2.04"
         [:div
          "8" ;(chess-row)[:br]
          "7" ;(chess-row)[:br]
          "6" ;(chess-row)[:br]
          "5" ;(chess-row)[:br]
          "4" ;(chess-row)[:br]
          "3" ;(chess-row)[:br]
          "2" ;(chess-row)[:br]
          "1" ;(chess-row)[:br]
          ]))