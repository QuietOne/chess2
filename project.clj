(defproject chess2 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                [org.clojure/clojurescript "0.0-2371"]
                [reagent "0.5.0-alpha"]
                [compojure "1.1.8"]
                [hiccup "1.0.5"]
                [ring "1.3.1" :exclusions [[ring/ring-core]
                                          [org.clojure/clojure]]]
                [liberator "0.12.2"]
                [cheshire "5.4.0"]
                [clj-http "0.7.8"]
                [com.cemerick/friend "0.2.1"]]
   
  :plugins [[lein-ring "0.8.11"]
           [lein-localrepo "0.5.3" :exclusions [org.clojure/clojure]]
           [lein-cljsbuild "1.0.3"]]
  
  :source-paths ["src/clj"]
  :cljsbuild {:builds {:app {:source-paths "src/cljs"
                            :compiler {:output-to     "resources/public/js/app.js"
                                       :output-dir    "resources/public/js/out"
                                       :source-map    "resources/public/js/out.js.map"
                                       :externs       ["react/externs/react.js"]
                                       :optimizations :none
                                       :pretty-print  true
                                       :preamble ["reagent/react.js"]}}}} 
  
  :ring {:handler routes.router/app}
  :main routes.router
  )
