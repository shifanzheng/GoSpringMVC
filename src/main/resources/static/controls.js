GameControls = function (element, game) {
    this.element = element;
    this.game = game;
    this.textInfo = element.querySelector(".text-info p");
    this.gameInfo = element.querySelector(".game-info p");

    this.setText = function (str) {
        this.textInfo.innerText = str;
    };

    var moveArray = [];

    this.updateStats = function () {

        var newGameInfo = "";
        newGameInfo += "Black stones captured: " + this.game.currentState().blackStonesCaptured;
        newGameInfo += "\n\n";
        newGameInfo += "White stones captured: " + this.game.currentState().whiteStonesCaptured;
        newGameInfo += "\n\n";

        newGameInfo += "Move " + this.game.currentState().moveNumber;

        if (this.game.currentState().playedPoint) {
            var moveCoordinate = this.game.coordinatesFor(this.game.currentState().playedPoint.y, this.game.currentState().playedPoint.x);
            var playerColor = this.game.currentState().color[0].toUpperCase() + this.game.currentState().color.substr(1);

            newGameInfo += " (" + moveCoordinate + ")";

            var moveListText = playerColor + " played at " + moveCoordinate;
            if (moveArray[moveArray.length - 1] !== moveListText)
                moveArray.push(moveListText);
            newGameInfo += "\n\n";
            newGameInfo += "Move List" + "\n";
            var i;
            for (i = 0; i < moveArray.length; i++) {
                newGameInfo += moveArray[i] + "\n";
            }
        }

        newGameInfo += "\n\n";

        var currentState = this.game.currentState();

        if (currentState.pass) {
            var player = currentState.color[0].toUpperCase() + currentState.color.substr(1);
            newGameInfo += player + " passed."
        }

        this.gameInfo.innerText = newGameInfo;

        if (currentState.pass) {
            var str = "";

            if (this.game.isOver()) {
                str += "Game over.";
                str += "\n\n"
                str += "Black's score is " + this.game.score().black;
                str += "\n\n";
                str += "White's score is " + this.game.score().white;
            }

            this.setText(str)
        } else {
            this.setText("");
        }
    };

    this.setup = function () {
        var controls = this;

        var passButton = document.querySelector(".pass");

        passButton.addEventListener("click", function (e) {
            e.preventDefault();

            controls.game.pass();
        });
    }
};
