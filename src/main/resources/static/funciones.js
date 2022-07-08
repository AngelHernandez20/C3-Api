function eliminar(id){
    swal({
        title: "Está seguro de eliminar?",
        text: "Once deleted, you will not be able to recover this imaginary file!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            $.ajax({
                url:"/eliminar/"+id,
                success: function (res){
                    console.log(res);

                }
            });
            if (willDelete) {
                swal("Poof! Your imaginary file has been deleted!", {
                    icon: "success",
                }).then((ok)=>{
                    if(ok){
                        location.href="/listar";
                    }

                });
            } else {
                swal("Your imaginary file is safe!");
            }
        });

}