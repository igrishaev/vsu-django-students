(ns students.routing
  (:require
   [secretary.core :as secretary :refer-macros [defroute]]
   [students.group-list :as group-list]
   [students.group-dialog :as group-dialog]
   [students.content :as content]
   [students.student-dialog :as student-dialog]))

(defroute #"/" []
  (content/close)
  (group-list/update))

(defroute #"/groups/(\d+)" [id]
  (content/close)
  (group-dialog/update id))

(defroute #"/students/(\d+)" [id]
  (content/close)
  (student-dialog/update id))

(defn setup []
  (secretary/set-config! :prefix "#")
  (set! (.-onhashchange js/window)
        #(-> js/window
             .-location
             .-hash
             secretary/dispatch!)))
