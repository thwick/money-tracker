angular.module('budgetControllers').controller('HomeCtrl', ['$scope', 'Home',
  function($scope, Home) {
    $scope.accounts = Home.query();
  }
]);