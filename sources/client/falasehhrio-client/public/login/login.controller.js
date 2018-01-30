(function () {
    'use strict';

    angular
        .module('app')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$location', 'AuthenticationService', 'UserService', 'FlashService'];
    function LoginController($location, AuthenticationService, FlashService) {
        var vm = this;

        vm.login = login;
        vm.loginMedia = loginMedia;
        vm.loginMitreId = loginMitreId;

        (function initController() {
            console.log("reset login status");
            AuthenticationService.ClearCredentials();
        })();

        function login() {
            vm.dataLoading = true;
            AuthenticationService.Login(vm.username, vm.password, function (response) {
                if (response.success) {
                    AuthenticationService.SetCredentials(vm.username, vm.password);
                    $location.path('/');
                } else {
                    FlashService.Error(response.message);
                    vm.dataLoading = false;
                }
            });
        };
        
		function loginMedia(media) {
		  vm.dataLoading = true;
		  
		  console.log("[START signout]");
		  firebase.auth().signOut();
		  console.log("[END signout]");
          
		  console.log("[START createprovider]");
          var provider = new firebase.auth.GoogleAuthProvider();
          console.log("[END createprovider]");
          
          console.log("[START addscopes]");
          provider.addScope('https://www.googleapis.com/auth/plus.login');
          console.log("[END addscopes]");
          
          console.log("[START signin]");
          firebase.auth().signInWithRedirect(provider);
          console.log("[END signin]");
		};
        
        function loginMitreId(media) {
        	console.log(media);
        };
        
        /**
         * initApp handles setting up UI event listeners and registering Firebase auth listeners:
         *  - firebase.auth().onAuthStateChanged: This listener is called when the user is signed in or
         *    out, and that is where we update the UI.
         *  - firebase.auth().getRedirectResult(): This promise completes when the user gets back from
         *    the auth redirect flow. It is where you can get the OAuth access token from the IDP.
         */
        function initApp() {
          console.log("Result from Redirect auth flow.");
          console.log("[START getidptoken]");
          firebase.auth().getRedirectResult().then(function(result) {
            if (result.credential) {
              console.log("This gives you a Google Access Token. You can use it to access the Google API.");
              var token = result.credential.accessToken;
              console.log("[START_EXCLUDE]");
              vm.token = token;
              console.log("[START_SETCREDENTIALS]");
              AuthenticationService.SetCredentials("google", result.user.email, token);
              console.log("[END_SETCREDENTIALS]");
              console.log("[START_RELOAD]");
              $location.path('/');
              console.log("[END_RELOAD]");
            } else {
            	vm.token = 'null';
              console.log("[END_EXCLUDE]");
            }
            console.log("The signed-in user info.");
            vm.user = result.user;
          }).catch(function(error) {
            console.log("Handle Errors here.");
            var errorCode = error.code;
            var errorMessage = error.message;
            console.log("The email of the user's account used.");
            var email = error.email;
            console.log("The firebase.auth.AuthCredential type that was used.");
            var credential = error.credential;
            console.log("[START_EXCLUDE]");
            if (errorCode === 'auth/account-exists-with-different-credential') {
              alert('You have already signed up with a different auth provider for that email.');
              console.log("If you are using multiple auth providers on your app you should handle linking");
              console.log("the user's accounts here.");
            } else {
              console.error(error);
            }
            console.log("[END_EXCLUDE]");
          });
          console.log("[END getidptoken]");
          console.log("Listening for auth state changes.");
          console.log("[START authstatelistener]");
          firebase.auth().onAuthStateChanged(function(user) {
            if (user) {
            	console.log("[START_SETCREDENTIALS]");
                AuthenticationService.SetCredentials("google", user.email, vm.token);
                console.log("[END_SETCREDENTIALS]");
                console.log("[START_RELOAD]");
                $location.path('/');
                console.log("[END_RELOAD]");
            } else {
                vm.dataLoading = false;
            }
          });
        }
        
        initApp();
    }

})();
