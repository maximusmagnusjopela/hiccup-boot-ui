(ns hiccup-boot-ui.render)

(defprotocol NavRender
  "How to render component in a nav-bar"
  (nav-render [component] "returns a hiccup structure from the component"))

(extend-protocol NavRender
  clojure.lang.IPersistentMap
  (nav-render [{:keys [text link] :or {text "" link ""}}]
    [:li [:a {:href link} text]])

  clojure.lang.IPersistentList
  (nav-render [coll]
    (nav-render (seq coll)))

  clojure.lang.IPersistentVector
  (nav-render [coll]
    (nav-render (seq coll)))

  clojure.lang.IPersistentSet
  (nav-render [coll]
    (nav-render (seq coll)))

  clojure.lang.ISeq
  (nav-render [coll]
    (let [drop-name (first coll)
          items (rest coll)
          drop-items (for [i items] (nav-render i))]
    [:li.dropdown 
     [:a {:href "#" 
          :class "dropdown-toggle" 
          :data-toggle "dropdown" 
          :role "button" 
          :aria-haspopup "true" 
          :aria-expanded "false"} drop-name [:span.caret]]
    [:ul.dropdown-menu
     (interpose [:li.divider {:role "separator"}] drop-items)]])))


(nav-render ["careers" 
             {:text "jobs" :link "http://jobs.com"}
             {:text "work culture" :link "http://workculture.com"}])

