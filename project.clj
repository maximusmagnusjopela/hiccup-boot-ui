(defproject hiccup-boot-ui "0.1.1"
  :description "Twitter bootstrap + hiccup web UI toolkit"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [hiccup "1.0.5"]]
  :main ^:skip-aot hiccup-boot-ui.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
