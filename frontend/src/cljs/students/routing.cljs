(ns students.routing
  (:require
   [secretary.core :as secretary :refer-macros [defroute]]
   [students.group-list :as group-list]
   [students.group-dialog :as group-dialog]
   [students.student-dialog :as student-dialog]))

(defroute #"/" []
  (group-list/update))

(defroute #"/groups/(\d+)" [id]
  (group-dialog/update id))

(defroute #"/students/(\d+)" [id]
  (student-dialog/update id))

(defn setup []
  (secretary/set-config! :prefix "#")
  (set! (.-onhashchange js/window)
        #(-> js/window
             .-location
             .-hash
             secretary/dispatch!)))
