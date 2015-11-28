(ns hiccup-boot-ui.core
  (:require [hiccup.core :refer :all]
            [hiccup.page :refer :all]
            [hiccup-boot-ui.render :refer :all]))

(defn base
  [title & components]
  [:head
   [:title title]
   (include-css "file:///home/dev/Programming/clojure/hiccup-boot-ui/resources/public/css/theme.min.css")
   (include-css "file:///home/dev/Programming/clojure/hiccup-boot-ui/resources/public/css/imperial.css")
   (include-js "https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js")
   (include-js "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js")
  [:body components]])

(defn nav-bar
  [components]
  [:nav.navbar.navbar-static-top
   [:div.container
    [:div.collapse.navbar-collapse
     [:ul.nav.navbar-nav
      (for [c components] (nav-render c))]]]])

(defn marketing-column
  "Creates a marketing column"
  [col-class {:keys [img heading text link]}]
  (let [{url :url link-text :text} link]
    [:div {:class col-class}
     [:img {:src img :alt "image"}]
     [:h2 heading]
     [:p text]
     [:p [:a.btn.btn-default link-text]]]))

(marketing-column "col-lg-4" 
                  {:img "image.png"
                   :heading "some heading"
                   :text "some text"
                   :link {:url "http://google.com" :text "this is google"}})


(defn marketing-row
  "creates a marketing row that contains a collection of marketing column"
  [marketing-columns]
  (let [coll-class (->> marketing-columns 
                        count
                        (str "col-lg-"))]
    [:div.row 
     (for [c marketing-columns] (marketing-column coll-class c))]))

;todo IMPLEMENT THIS
(defn marketing
  "returns a marketing columnar data structure"
  [market-columns]
  nil)

(defn jumbo
  [content]
  [:div.jumbotron.text-center content])

(defn footer
  [content]
  [:footer.footer 
   [:div.container
    [:p.text-right content]]])

(->> (base "Imperial Systems Corporation"
      [:div.container [:div.page-header [:img.center-block {:src "file:///home/dev/Documents/Picture/imperialsys/Imperial_Sys_optimized.svg"}]]]
      (nav-bar [["Services" 
                 {:text "Consulting" 
                  :link "http://google.com"}
                 {:text "Machine Learning"
                  :link "http://google.com"}]
                ["Products"
                 {:text "Novown" :link "http://google.com"}
                 {:text "DataLink API" :link "http://google.com"}]
                ["Corporation" 
                 {:text "Contact" :link "http://has-jobs.com"}
                 {:text "Investors" :link "http://has-jobs.com"}
                 {:text "Chief Executive Officer" :link "http://has-jobs.com"}]])
      (jumbo [:h1 "Creating Future Technologies" 
              [:h3 "We build the information systems that will power the world of tomorrow"]
              [:a.btn.btn-default.btn-lg {:href "#"} "Discover our vision"]]) 
      [:div.container [:h1 "Consulting"] [:p "Elite consulting services"]])
    html5
    (spit "index.html"))

