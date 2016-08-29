(ns students.sidebar
  (:require
   [students.group-list :as group-list]))

(defn component []
  [group-list/component])
