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
        $("getStarted").click($.proxy(t.createCampaign, t));
    },

    /**
     * Handles submit event of the form and does the following,
     *   a) prevents default action
     *   b) creates a welcome page document via ajax
     *   c) takes the user to the editor if this is the first page they are linking
     *   d) if the user has linked pages already redirects them to the dashboard.
     */
    showContactOptions: function() {

        // prevent the default action.
        e.preventDefault();

        var target = $(e.target),
                templateId = target.attr("data-tid"),
                t = this,
                endPoint = t.endPointUrl,
                requestData = {
                "pageId": templatePickerConfig.fbPageId,
              "templateId": templateId,
              "pageName": templatePickerConfig.fbPageName,
              "pageCategory": templatePickerConfig.fbPageCategory,
              "avatarUrl": templatePickerConfig.fbAvatarUrl,
              "connectedAccount": templatePickerConfig.connectedAccount
            },

            requestConfig = {
                type: "POST",
                url: endPoint,
                contentType: "application/x-www-form-urlencoded",
                data: requestData,
                dataType: "json",
                context: t,
                success: t.processCreateCampaignResponse,
                error: t.processCreateCampaignFailureResponse
            };

        t.isTemplateGated = target.attr("data-gated");

        // make the request.
        $.ajax(requestConfig);

    },

    /**
     * Processes a successful http response for create welcome page request.
     *
     */
    processCreateCampaignResponse: function(response) {
        var success = response.status;

        if (success) {
            this.openWelcomePageEditor(response.docCollectionId, response.socialCampaignId);
        } else {
            //(TODO): show appropriate error message to the user.
            alert("oops the request failed with errorCode: " + response.errorCode);
        }
    }

};

$(document).ready(TemplatePicker.init());
