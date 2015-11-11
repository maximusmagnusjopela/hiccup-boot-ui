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

(defn jumbo
  [content]
  [:div.jumbotron
   [:div.container content]])

(defn footer
  [content]
  [:footer.footer 
   [:div.container
    [:p.text-muted content]]])

(->> (base "Imperial Systems Corporation"
      [:div.container [:div.page-header [:img.center-block {:src "/home/dev/Documents/Picture/Imperial_Sys_optimized.svg"}]]]
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
      (jumbo [:h1 "Imperial Systems Corporation" 
              [:p "We build information systems that power the future"]]) 
      [:div.container [:h1 "Consulting"] [:p "Elite consulting services"]]
      (footer "Imperial information systems &copy; 2015"))
    html5
    (spit "index.html"))
