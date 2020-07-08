var stateObject = {
    "Jordan":["Amman","Irbid","jerash","Aqaba"],
    "India": ["Delhi","Kerala","Goa"],
    "Australia": ["South Australia", "Victoria"],
    "Canada": ["Alberta", "Columbia"]
}
window.onload = function () {
    var countySel = document.getElementById("countySel"),
        stateSel = document.getElementById("stateSel");
    for (var country in stateObject) {
        countySel.options[countySel.options.length] = new Option(country, country);
    }
    countySel.onchange = function () {
        stateSel.length = 1; // remove all options bar first
        if (this.selectedIndex < 1) return; // done
        var state = stateObject[countySel.value];
        for (var i = 0; i < state.length; i++) {
            stateSel.options[stateSel.options.length] = new Option(state, state);
        }
    }
    countySel.onchange(); // reset in case page is reloaded
    stateSel.onchange = function () {
        if (this.selectedIndex < 1) return; // done
    }
}