/**
 * 静态文件优先级
 * src/main/resources/META-INF.resources
 * src/main/resources/resources
 * src/main/resources/static
 * src/main/resources/public
 *
 * js引用
 * <script type="text/javascript" th:src="@{/js/main.js}"></script>
 */
function load(){
    alert("static");
}