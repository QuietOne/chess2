(defproject chess2 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.8"]
                 [hiccup "1.0.5"]
                 [ring "1.3.1"]
                 [clj-http "0.7.8"]
                 ]
  :plugins [[lein-ring "0.8.11"]
            [lein-localrepo "0.5.3"]
            ]
  
  :ring {:handler routes.router/app}
  )