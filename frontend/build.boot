(set-env!
 :source-paths #{"src/cljs"}
 :resource-paths #{"html"}

 :dependencies '[[adzerk/boot-cljs "1.7.170-3"]
                 [reagent "0.6.0-rc"]
                 [secretary "1.2.3"]
                 [cljs-ajax "0.5.8"]])

(require '[adzerk.boot-cljs :refer [cljs]])
