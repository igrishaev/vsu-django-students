(ns students.core
  (:require
   [reagent.core :as r]
   [students.routing :as routing]
   [students.sidebar :as sidebar]
   [students.content :as content]))

(enable-console-print!)

(routing/setup)

(defn ^:export main []
  (r/render [sidebar/component] (js/document.getElementById "sidebar"))
  (r/render [content/component] (js/document.getElementById "content"))
  (set! (-> js/window .-location .-hash) "/"))

(main)
