(ns chess2.army.classic.bishop
  (use chess2.chessboard))

(defn possible-move? [chessboard fromx fromy tox toy]
  (cond; four ways in which bishop can move
     (and 
       (< (get-x-num fromx) (get-x-num tox)) 
       (< fromy toy)) (every? #(not-occupied? chessboard (calc-offset-x fromx %) (+ fromy %)) 
                              (range 1 (java.lang.Math/abs (offset-x fromx tox))))
     (and 
       (> (get-x-num fromx) (get-x-num tox)) 
       (< fromy toy)) (every? #(not-occupied? chessboard (calc-offset-x fromx (- %)) (+ fromy %)) 
                              (range 1 (java.lang.Math/abs (offset-x fromx tox))))
     (and 
       (< (get-x-num fromx) (get-x-num tox)) 
       (> fromy toy)) (every? #(not-occupied? chessboard (calc-offset-x fromx %) (- fromy %)) 
                              (range 1 (java.lang.Math/abs (offset-x fromx tox))))
     (and 
       (> (get-x-num fromx) (get-x-num tox)) 
       (> fromy toy)) (every? #(not-occupied? chessboard (calc-offset-x fromx (- %)) (- fromy %)) 
                              (range 1 (java.lang.Math/abs (offset-x fromx tox))))))

(defn eat? [chessboard fromx fromy tox toy]
 (and
   (occupied? chessboard tox toy)
   (not-same-color? chessboard fromx fromy tox toy)
   (= (java.lang.Math/abs (offset-x fromx tox)) 
      (java.lang.Math/abs (offset-y fromy toy)))
   (possible-move? chessboard fromx fromy tox toy)))


(defn move? [chessboard fromx fromy tox toy]
  (and
    (not-occupied? chessboard tox toy)
    (= (java.lang.Math/abs (offset-x fromx tox)) 
       (java.lang.Math/abs (offset-y fromy toy)))
    (possible-move? chessboard fromx fromy tox toy)))


(defn moveable? [chessboard fromx fromy tox toy]
  (and
    (valid-movement? fromx fromy tox toy)
    (or
      (eat? chessboard fromx fromy tox toy)
      (move? chessboard fromx fromy tox toy))))

(defn available-moves [chessboard x y]
  (reduce (fn [acc column]
            (reduce (fn [acc1 row]
                      (if (moveable? chessboard x y column row)
                        (conj acc1 [column row])
                        acc1)) acc (range 8))
            ) [] [:a :b :c :d :e :f :g :h]))
