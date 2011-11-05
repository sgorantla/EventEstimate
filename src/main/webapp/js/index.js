/**
 * This module implements all the JS interactions on template picker page.
 */

/**
 * Constants.
 */
var CONST = {
    WELCOMPAGE_EDITOR_OVERLAY_ID: "welcome-page-editor"
};


/**
 * Static class that encloses all the functionality in a namespace.
 */
var EventTemplate = {

    /**
     * Initializer called on document ready.
     */
    init: function() {
        var t = this;
        t.endPointUrl = "/scui-webapp/campaign/json/createCampaign";

        // form submit event listener.
        $("#getStarted").click($.proxy(t.showContactOptions, t));
    },

    /**
     * Handles submit event of the form and does the following,
     *   a) prevents default action
     *   b) creates a welcome page document via ajax
     *   c) takes the user to the editor if this is the first page they are linking
     *   d) if the user has linked pages already redirects them to the dashboard.
     */
    showContactOptions: function(e) {

        // prevent the default action.
        e.preventDefault();

        var container = $("<div/>");
        container.css({"height":"400px"});

        container.load("steps/step1.j", function(result){
            container.find(".close").click(function() {
               $.unblockUI();
            });

            container.find("#ctctConnectButton").click(function(){
                container.load("steps/step2.j");
            });

            $(".callout").hide();
            $.blockUI({
                css: {
                    border: 'none',
                    padding: '15px',
                    backgroundColor: 'transparent',
                    opacity: .5,
                    color: '#fff',
                    centerY: true,
                    centerX: true,
                    width: '35%'
                },
                message : container
            });
        })

    },

    /**
     * Processes a successful http response for create welcome page request.
     *
     */
    processStep: function(response) {
        var success = response.status;
        alert(response)
    },

    processError: function(response) {
        alert("ERROR == " + response);
    }

};

$(document).ready(EventTemplate.init());
