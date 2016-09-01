(ns students.group-list
  (:require
   [students.utils :refer [format]]
   [students.group-dialog :as group-dialog]
   [reagent.core :as r]
   [ajax.core :refer [GET]]))

(defn component []
  (let [state (r/atom nil)
        url "/api/groups/"]
    (GET url {:handler #(reset! state %)
              :response-format :json
              :keywords? true})
    (fn []
      [:ul.nav.nav-list
       ^{:key :title} [:li.nav-header "Группы"]
       (for [group @state]
         (let [group-id (:id group)]
           ^{:key group-id}
           [:li
            [:a {:href (format "#/groups/%s" group-id)}
             (:title group)]]))])))
