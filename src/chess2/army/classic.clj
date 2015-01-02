(ns chess2.army.classic)

;return vector of available moves
(defn pawn-available-moves [x y])
(defn rook-available-moves [x y])
(defn knight-available-moves [x y])
(defn bishop-available-moves [x y])
(defn queen-available-moves [x y])
(defn king-available-moves [x y])

;return if it is possible to move from to another space
(defn pawn-move? [fromx fromy tox toy])
(defn rook-move? [fromx fromy tox toy])
(defn knight-move? [fromx fromy tox toy])
(defn bishop-move? [fromx fromy tox toy])
(defn queen-move? [fromx fromy tox toy])
(defn king-move? [fromx fromy tox toy])

;return new chessboard
(defn pawn-move [fromx fromy tox toy])
(defn rook-move [fromx fromy tox toy])
(defn knight-move [fromx fromy tox toy])
(defn bishop-move [fromx fromy tox toy])
(defn queen-move [fromx fromy tox toy])
(defn king-move [fromx fromy tox toy])