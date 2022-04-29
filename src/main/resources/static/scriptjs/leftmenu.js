$(document).ready(function(){

    $.ajax({
        type: "POST",
        cache: false,
        async: true,
        url: '/menulist',
        data: {'name': 'soya'},
        success: function (maplist) {
            let menulist = "";
            if(maplist != null){

                // console.log(maplist);
                $.map(maplist, function (value1, key1) {
                    menulist = '                        <li class="nav-item">\n' +
                        '                            <a href="#" class="nav-link">\n' +
                        '                                <i class="nav-icon fas fa-th"></i>\n' +
                        '                                <p>\n' +
                        '                                    ' + key1 + '\n' +
                        '                                    <i class="right fas fa-angle-left"></i>\n' +
                        '                                </p>\n' +
                        '                            </a>\n' +
                        '                            <ul class="nav nav-treeview" style="display: none;" data-depth="1">\n' +
                        '                            </ul>\n' +
                        '                        </li>\n';
                    // console.log("key1 === " + key1);
                    $('#menu').append(menulist);
                    $.map(value1, function (value2, key2) {
                        menulist = '                                    <li class="nav-item">\n' +
                            '                                        <a href="/" class="nav-link">\n' +
                            '                                            <i class="far fa-circle nav-icon"></i>\n' +
                            '                                            <p>' + value2.table_name + '</p>\n' +
                            '                                        </a>\n' +
                            '                                    </li>\n';
                        $("ul[data-depth='1']").append(menulist);
                        // console.log("key2 ===" + key2);
                        // console.log("value2 ===" + value2.table_name);

                    });
                });
            }else{
                alert("메뉴 에러");
            }
        },
        error: function () {
            alert("메뉴 에러");

        }
    });
});
