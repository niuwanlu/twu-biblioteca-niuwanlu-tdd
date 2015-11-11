$().ready(function () {

    VALIDATION.UTIL.setupFormValidation();

});

    $.validator.setDefaults({
        onfocusout: function(element) {
            this.element(element);
        }
    });

    var VALIDATION = {};

    VALIDATION.UTIL =
    {
        setupFormValidation: function () {
            $("#register-form").validate({

                rules: {
                    username: {
                        required: true
                    },
                    password: {
                        required: true
                    }
                },

                messages: {
                    username: {
                        required: "Please create a username"
                    },
                    password: {
                        required: "Please create a password"
                    }
                }

            });
        }
    };



