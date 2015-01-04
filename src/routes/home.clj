(ns routes.home
  (:use routes.template)
  (:use hiccup.page)
  (:use hiccup.element)
  )


(defn home-page []
  (layout "Home" 
          [:h1 "Welcome to the game of Chess 2.04"]
          [:p
           [:button 
            (link-to "/game_rules" "Game rules")]
           ]
          [:p
           [:button "Play a Single Player Game"]
           ]
          [:p
           [:button 
            (link-to "/multiplayer-offline" "Play a MultiPlayer Offline Game")]
           ]
          [:p
           [:button "Play a MultiPlayer Online Game"]
           ]
          )
  )