$(function () {
    $("#datepicker").datepicker({
        changeMonth: true,
        changeYear: true,
        monthNames: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Augosto", "Setembro", "Outubro", "Novembro", "Dezembro"],
        monthNamesShort: ["Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "De"],
        dayNamesMin: [ "Do", "Se", "Te", "Qa", "Qi", "Se", "Sa" ],
        showAnim: "fadeIn",
        dateFormat: "dd/mm/yy",
        minDate: "-120Y",
        maxDate: "+0M +0D"
    });
});
