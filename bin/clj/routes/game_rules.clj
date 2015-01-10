(ns routes.game-rules
  (:use routes.template)
  (:use hiccup.element)
  (:use hiccup.page)
  )

(defn overview-of-chess []
  [:div {:id "overview"}
   [:h1 "Overview of Chess 2"]
   [:p "Chess 1 was a hit, no doubt about it. Chess 2 seeks to build on the greatness of the original while addressing a few problems and also going in a new direction. Chess 2 is also designed so that you can play it with a regular Chess set without too much trouble."]
   [:p "The first, most dramatic difference from the original game is that there are 6 armies to choose from (Classic, Nemesis, Empowered, Reaper, Two Kings, and Animals). Mirror matches are allowed (same army vs. same army), which means there are 21 different matchups, instead of the single matchup in Chess 1 (black vs. white)."]
   [:p "Next, a double-blind bidding mechanic called dueling puts more emphasis on reading the opponent and adapting, rather than reliance on memorized plans. The bidding lets players “debate” how important a given capture is, and it also makes opening books much harder to develop. Further, it introduces a mind-game element of predicting what the opponent will do that doesn’t occur in Chess 1."]
   [:p "Finally, a new win condition makes endgames much faster, eliminates stalemates, and ends games before they fall down a slippery slope."]
   ]
  )

(defn new-win-condition []
  [:div {:id "new-win-condition"}
   [:h1 "New Win Condition: Midline Invasion"]
   [:p "You can still win by checkmate, but you also win if your king crosses the midline of the board. Each move has added significance, because you must weigh how much it helps or hurts each player’s chances of winning by king crossing the midline in addition to the usual considerations of furthering a checkmate."]
   [:p "Just like in Chess 1, it’s illegal to move into check, so to win by Midline Invasion, your King must land on the 5th rank without being in check. Unlike Chess 1 though, there are no stalemates. If you have no legal moves, you lose the game. While stalemates are common in Chess 1, they aren’t needed in Chess 2 because the Midline Invasion rule provides an even stronger option that a player can aim for when he’s down on material."]
   [:image {:src "/images/midline_invasion_image.png" :title "A win by Midline Invasion"}]
   ]
  )

(defn dueling []
  [:div {:id "dueling"}
   [:h1 "Dueling"]
   [:p "Dueling allows you to spend a new resource called stones to threaten to destroy a piece that takes one of your pieces. Try to trick the opponent into wasting his stones because if he runs out first, you automatically win any further duels."]
   [:p [:i "You start with 3 stones and gain 1 stone each time you capture an enemy pawn, up to a maximum of 6 stones."]]
   [:p "Whenever you would capture any piece, the defender can initiate a duel. If your piece is higher rank than his (ranks: pawn -> knight/bishop -> rook -> queen), he must pay 1 stone to initiate a duel. To duel, you each put 0, 1, or 2 stones in your closed fists, then simultaneously reveal them. All stones revealed are destroyed. The winner of the duel is the one who showed more stones--ties go to the attacker."]
   [:p "If the attacker wins a duel, he takes the piece in question as in normal Chess."]
   [:p "If the defender wins, he still loses his piece, but the attacker ALSO loses the piece he attacked with."]
   [:p "Initiating a duel and bidding 0 is a bluff to make the opponent waste stones. The attacker calls your bluff by bidding 0 himself. He wins because attacker always wins on a tie and in addition, the attacker can choose to gain 1 stone or cause the defender to lose 1 stone. (A player can't have more than 6 stones.)"]
   (unordered-list
     ["Kings cannot be involved in duels because they have \"Diplomatic Immunity.\" (They can't initiate a duel or be dueled.)"
      "Players with 0 stones cannot initiate duels, but they can be dueled against. When you duel against a player with 0 stones, you must bid 1 and you automatically win the duel."
      "If you lose a pawn in a duel, your opponent does gain a stone."
      ])
   ]
  )
(defn classic []
  [:div {:id "classic"}
   [:h2 "Classic (balanced)"]
   [:p "It's regular old Chess. This is the only army that can castle."]
   ]
  )

(defn nemesis []
  [:div {:id "nemesis"}
   [:h2 "Nemesis (favors pawns)"]
   [:p "The queen is replaced with a new piece: the nemesis. The nemesis piece moves as a queen, but cannot capture or be captured except by the enemy king. (It can check and checkmate a king, and a king can capture it.)"]
   [:p "Your pawns can move as normal pawns, or alternatively they can make a nemesis move, which is a move one space toward the enemy king. (Imagine a box drawn around your pawn and the enemy king; moving inside that box is a nemesis move. That move can be toward your back row if the enemy king is behind your pawn). Nemesis pawns can only capture pieces (or threaten a king) the same way normal pawns can: diagonally forward. Your pawns cannot move two spaces at the start of the game."]
   [:image {:src "/images/nemesis_pawn_moves.png" :title "Nemesis pawn moves"}]
   ]
  )

(defn empowered []
  [:div {:id "empowered"}
   [:h2 "Empowered (favors knights/bishops/rooks)"]
   [:p "While a knight, bishop, or rook is adjacent (diagonals do not count) to another knight, bishop, or rook on your team, each piece gains the movement powers of its neighbor in addition to its regular movement powers. (King, queen, and pawns cannot gain movement properties.) To compensate for this power, the queen can only move as a king."]
   [:p "Example: if knight, bishop, rook are in a line, adjacent to one another, then knight can move as knight+bishop. Bishop can move as knight+bishop+rook. Rook can move as rook +bishop. The knight does NOT gain rook movement in this example, nor does the rook gain knight movement."]
   [:image {:src "/images/empowered_pieces.png" :title "Empowered pieces Purple lines show Empowered movement"}]
   ]
  )

(defn reaper []
  [:div {:id "reaper"}
   [:h2 "Reaper (favors queen)"]
   [:p "The queen is called a reaper. It can teleport and capture anywhere on the board except the enemy's back row. The reaper cannot capture a king. Also, the rooks are ghosts that can teleport to any open square on the board. The ghosts cannot capture or be captured."]
   ]
  )

(defn two-kings []
  [:div {:id "two-kings"}
   [:h2 "Two Kings (favors kings)"]
   [:p "You have no queen, but instead have two kings called warrior kings. If either one is checkmated, you lose. To win by the Midline Invasion method, BOTH warrior kings must cross the midline of the board into enemy territory."]
   [:p "A warrior king can move and capture the same way as a regular king, though it also has the option of doing a Whirlwind attack. For this, the warrior king stays in place and destroys all adjacent pieces—friendly and enemy—including diagonally adjacent pieces. You cannot Whirlwind if your other warrior king is adjacent."]
   [:p "After each of your turns, you may (optionally) take a special king-turn where you only move a warrior king. On your normal turn, there are no special restrictions. You can move either warrior king, or some other piece, whatever you want. During your king-turn, you may ONLY move a warrior king or perform Whirlwind with a warrior king. It doesn’t matter if you moved that warrior king or not during your normal turn."]
   [:p "You can’t move into check on your normal-turn or your king-turn."]
   [:p "Helpful hint: whenever you choose to skip this extra king-turn, it would be helpful if you tap one of your warrior kings as a signal to your opponent that he can take his turn."]
   [:image {:src "/images/whirlwind_attack.png" :title "Whirlwind attack"}]
   ]
   )

(defn animals []
  [:div {:id "animals"}
   [:h2 "Animals (wild card)"]
   (unordered-list
     [[:p [:b "Knight -> Wild Horse."] "Moves as a knight, but can capture its own pieces."]
      [:p [:b "Bishop -> Tiger."] "Can only move up to 2 squares diagonally, but does not move when it captures (immediately jumps back to the square it attacked from)."]
      [:p [:b "Rook -> Elephant."] "Can only move up to 3 squares orthogonally. It can capture both friendly and enemy pieces, even multiple pieces in one move. If it captures a piece, the elephant rampages and must move its maximum distance, capturing everything in its path. Also, the elephant cannot be captured by a piece more than 2 squares away. (Draw a 5x5 box with Elephant in the center. It can't be captured by pieces outside the box.)"]
      [:p [:b "Queen -> Jungle Queen."] "Can move as a rook or as a knight."]
      ])
   [:image {:src "/images/wild_horse.png" :title "Wild Horse can take own pieces"}]
   [:image {:src "/images/tiger.png" :title "Tiger returns to where it pounced from when it captures"}]
   [:image {:src "/images/elephant.png" :title "Only pieces in the blue box can capture the elephant."}]
   [:image {:src "/images/jungle_queen.png" :title "Jungle queen moves as a rook or as a knight."}]
   ]
  )

(defn armies []
  [:div {:id "armies"}
   [:h1 "The Six Armies"]
   (ordered-list [(classic)(nemesis)(empowered)(reaper)(two-kings)(animals)])
   ]
  )

(defn choosing-army []
  [:div {:id "choosing-army"}
   [:h2 "Choosing Your Army"]
   [:p "Players choose their armies in a simultaneous, double-blind fashion at the start of each match. It’s permitted for both players to choose the same army. Though players will likely specialize in playing only one army, in a multiple-game match, the loser of a game may switch to any army for the next game. The winner of the previous game may not switch."]
   ]
  )

(defn promoting-pawns []
  [:div {:id "promoting-pawns"}
   [:h2 "Promoting Pawns"]
   [:p "When one of your pawns reaches the last row, you must promote it (not optional). You can promote to any piece that’s part of your army other than a pawn or a king (or a Warrior King). For example, a pawn on the Animals team could promote to a Tiger piece, but an Empowered pawn can’t promote to a Tiger because Tiger is not part of its army."]
   [:p "When you promote a pawn, your opponent does not get a stone."]
   ]
  )

(defn dueling-ranks []
  [:div {:id "dueling-ranks"}
   [:h2 "Dueling Ranks"]
   [:p "For purposes determining if you have to pay 1 stone to initiate a duel against a higher ranked piece, the only possible ranks are 1) pawn, 2) knight/bishop, 3) rook, and 4) queen. In other words, all special queens count as queens, even though the Empowered queen is rather weak. Elephants count as rooks. The wild horse and the tiger count as a knight/bishop. Nemesis pawns count as pawns."]
   ]
  )

(defn draws []
  [:div {:id "draws"}
   [:h2 "Draws"]
   [:p "There are no stalemates in Chess 2. The other types of draws from Chess 1 still apply here, though they are much more unlikely because of the Midline Invasion rule. The types of draws are: threefold repetition (when the same position occurs three times), the fifty-move rule (when the last fifty successive moves made by both players contain no capture or pawn move), and impossible checkmate (when neither player has sufficient material to checkmate, and Midline Invasion is not possible)."]
   ]
  )

(defn other-notes []
  [:div {:id "other-notes"}
   [:h2 "Other Notes"]
   (unordered-list [[:p "All pawns on all teams have the ability to en passant."]
                    [:p "Pieces cannot pass through the Reaper army’s ghost rooks or occupy the same square as a ghost rook."]
                    [:p "A warrior king’s Whirlwind cannot destroy a ghost rook."]
                    [:p "Even the reaper cannot take an elephant if its more than 2 squares away."]
                    ])
   ]
  )

(defn game-rules-page []
  (layout "Game rules"
          [:div
           (overview-of-chess)
           (new-win-condition)
           (dueling)
           (armies)
           (choosing-army)
           (promoting-pawns)
           (dueling-ranks)
           (draws)
           (other-notes)
           ]
           )
  )