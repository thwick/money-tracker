angular.module('budgetControllers').controller('ModalAccountDeleteCntrl', ['$scope', 'Account', '$log',
  function($scope, Account, $log) {
    
    $scope.ok = function () {
        Account.delete({ id: $scope.id });
    	$modalInstance.close();
  	};

    $scope.cancel = function () {
      $modalInstance.dismiss('cancel');
    };
   }
]);