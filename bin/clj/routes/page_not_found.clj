(ns routes.page-not-found
  (:use routes.template)
  (:use hiccup.element)
  (:use hiccup.page)
  )

(defn page-not-found []
  (layout-css "404 Page not found" 
              "/css/page-not-found.css"
              [:div {:class "error-page-wrap"}
               [:article {:class "error-page gradient"}
                [:hgroup
                 [:h1 "404"]
                 [:h2 "oops! page not found"]
                 (link-to {:class "error-back" :title "Back to site"} 
                          "#" "back")
                 ]
                ]
               ]
              )
  )

(page-not-found)