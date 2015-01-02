(ns chess2.core-test
  (use chess2.army.classic.pawn))

(def pos 
  {:a ["wr" "wp" "." "." "." "." "bp" "br"]
   :b ["wn" "wp" "." "." "." "." "bp" "bn"]
   :c ["wb" "wp" "bp" "." "." "." "bp" "bb"]
   :d ["wq" "wp" "." "." "." "." "bp" "bq"]
   :e ["wk" "wp" "." "." "." "." "bp" "bk"]
   :f ["wb" "wp" "." "." "." "." "bp" "bb"]
   :g ["wn" "wp" "." "." "." "." "bp" "bn"]
   :h ["wr" "wp" "." "." "." "." "bp" "br"]
   })

(available-moves pos :d 1)
(moveable? pos :d 1 :c 2)