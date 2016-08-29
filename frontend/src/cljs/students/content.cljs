(ns students.content
  (:require
   [students.group-dialog :as group-dialog]
   [students.student-dialog :as student-dialog]))

(defn close []
  (group-dialog/close)
  (student-dialog/close))

(defn component []
  [:div
   [group-dialog/component]
   [student-dialog/component]])
