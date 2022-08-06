<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta
      name="description"
      content="Citytours - Premium site template for city tours agencies, transfers and tickets."
    />
    <meta name="author" content="Ansonika" />
    <title>CITY TOURS - City tours and travel site template by Ansonika</title>

    <!-- Favicons-->
    <link
      rel="shortcut icon"
      href="<%=request.getContextPath()%>/Cart/html/img/favicon.ico"
      type="image/x-icon"
    />
    <link
      rel="apple-touch-icon"
      type="image/x-icon"
      href="<%=request.getContextPath()%>/Cart/html/img/apple-touch-icon-57x57-precomposed.png"
    />
    <link
      rel="apple-touch-icon"
      type="image/x-icon"
      sizes="72x72"
      href="<%=request.getContextPath()%>/Cart/html/img/apple-touch-icon-72x72-precomposed.png"
    />
    <link
      rel="apple-touch-icon"
      type="image/x-icon"
      sizes="114x114"
      href="<%=request.getContextPath()%>/Cart/html/img/apple-touch-icon-114x114-precomposed.png"
    />
    <link
      rel="apple-touch-icon"
      type="image/x-icon"
      sizes="144x144"
      href="<%=request.getContextPath()%>/Cart/html/css/img/apple-touch-icon-144x144-precomposed.png"
    />

    <!-- GOOGLE WEB FONT -->
    <link
      href="https://fonts.googleapis.com/css2?family=Gochi+Hand&family=Montserrat:wght@300;400;500;600;700&display=swap"
      rel="stylesheet"
    />

    <!-- COMMON CSS -->
    <link
      href="<%=request.getContextPath()%>/Cart/html/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link
      href="<%=request.getContextPath()%>/front-end/sightseeing/css/style.css"
      rel="stylesheet"
    />
    <link
      href="<%=request.getContextPath()%>/front-end/sightseeing/css/vendors.css"
      rel="stylesheet"
    />

    <!-- CUSTOM CSS -->
    <link
      href="<%=request.getContextPath()%>/front-end/sightseeing/css/custom.css"
      rel="stylesheet"
    />
    <style>
      #map {
        border-bottom: none;
        height: 550px;
        /* width: 100%;
              position: absolute;
              top: 0;
              left: 0; */
      }
      .like_title ul {
        height: 50px;
        width: 80%;
        /* border: 1px solid red; */
        background-color: #bbcfe2;
        position: relative;
      }
      .like_title ul p {
        font-size: 20px;
        font-family: "Montserrat", Arial, sans-serif;
        justify-content: center;
        /* align-items: center; */
        display: flex;
        margin: 0;
        position: absolute;
        top: 10px;
      }
      .like_content ul {
        height: 400px;
        width: 100%;
        /* border: 1px solid red; */
        background-color: #fff;
      }
      .mpa_list {
        margin-top: 0;
        background-color: #fff;
        height: 550px;
      }
      .wrap {
        text-align: center;
        padding-top: 20%;
      }
      .btn {
        background-color: #ffb80c;
        text-decoration: none;
        color: #1e1e1e;
        padding: 16px;
        border-radius: 5px;
      }

      .popup-wrap {
        width: 100%;
        height: 100%;
        display: none;
        position: fixed;
        top: 0px;
        left: 0px;
        content: "";
        background: rgba(0, 0, 0, 0.85);
      }

      .popup-box {
        width: 50%;
        padding: 50px 75px;
        transform: translate(-50%, -50%) scale(0.5);
        position: absolute;
        top: 50%;
        left: 50%;
        box-shadow: 0px 2px 16px rgba(0, 0, 0, 0.5);
        border-radius: 3px;
        background: #fff;
        text-align: center;
      }
      h2 {
        font-size: 32px;
        color: #1a1a1a;
      }

      h3 {
        font-size: 24px;
        color: #888;
      }

      .close-btn {
        width: 50px;
        height: 50px;
        display: inline-block;
        position: absolute;
        top: 10px;
        right: 10px;
        border-radius: 100%;
        background: #d75f70;
        font-weight: bold;
        text-decoration: none;
        color: #fff;
        line-height: 40px;
        font-size: 32px;
      }

      .transform-in,
      .transform-out {
        display: block;
        -webkit-transition: all ease 0.5s;
        transition: all ease 0.5s;
      }

      .transform-in {
        -webkit-transform: translate(-50%, -50%) scale(1);
        transform: translate(-50%, -50%) scale(1);
      }

      .transform-out {
        -webkit-transform: translate(-50%, -50%) scale(0.5);
        transform: translate(-50%, -50%) scale(0.5);
      }
    </style>
  </head>
  <body>
    <div id="preloader">
      <div class="sk-spinner sk-spinner-wave">
        <div class="sk-rect1"></div>
        <div class="sk-rect2"></div>
        <div class="sk-rect3"></div>
        <div class="sk-rect4"></div>
        <div class="sk-rect5"></div>
      </div>
    </div>
    <!-- End Preload -->

    <div class="layer"></div>
    <!-- Mobile menu overlay mask -->

    <!-- Header Plain:  add the id plain to header and change logo.png to logo_sticky.png ======================= -->
    <header id="plain">
      <div id="top_line">
        <div class="container">
          <div class="row">
            <div class="col-6">
              <i class="icon-phone"></i><strong>02 23456789</strong>
            </div>
            <div class="col-6">
              <ul id="top_links">
                <li><a href="#sign-in-dialog" id="access_link">登入</a></li>
                <li>
                  <a href="wishlist.html" id="wishlist_link">連絡我們</a>
                </li>
              </ul>
            </div>
          </div>
          <!-- End row -->
        </div>
        <!-- End container-->
      </div>
      <!-- End top line-->

      <div class="container">
        <div class="row">
          <div class="col-4">
            <div id="logo_home">
              <h1>
                <a href="index.html" title="Welcome to royal Pandora"
                  >Welcome to royal Pandora</a
                >
              </h1>
            </div>
          </div>
          <nav class="col-8">
            <a
              class="cmn-toggle-switch cmn-toggle-switch__htx open_close"
              href="javascript:void(0);"
              ><span>選單</span></a
            >
            <div class="main-menu">
              <div id="header_menu">
                <img
                  src="<%=request.getContextPath()%>/Cart/html/img/logo_sticky.png"
                  width="160"
                  height="34"
                  alt="City tours"
                />
              </div>
              <a href="#" class="open_close" id="close_in"
                ><i class="icon_set_1_icon-77"></i
              ></a>
              <ul>
                <li class="submenu">
                  <a
                    href="javascript:void(0);"
                    class="show-submenu"
                    style="width: 100px"
                    >行程管理
                  </a>
                </li>
                <li class="submenu">
                  <a
                    href="javascript:void(0);"
                    class="show-submenu"
                    style="width: 100px"
                    >郵輪介紹
                  </a>
                </li>
                <li class="submenu">
                  <a
                    href="javascript:void(0);"
                    class="show-submenu"
                    style="width: 100px"
                    >活動新訊
                  </a>
                </li>
                <li class="megamenu submenu">
                  <a
                    href="javascript:void(0);"
                    class="show-submenu-mega"
                    style="width: 100px"
                    >旅遊資訊</a
                  >

                  <!-- End row -->

                  <!-- End menu-wrapper -->
                </li>
                <li class="submenu">
                  <a href="javascript:void(0);" class="show-submenu"
                    >會員中心<i class="icon-down-open-mini"></i
                  ></a>
                  <ul>
                    <li>
                      <a href="all_restaurants_list.html">會員資訊</a>
                    </li>
                    <li>
                      <a href="all_restaurants_grid.html">會員資料修改</a>
                    </li>
                    <li>
                      <a href="all_restaurants_grid_masonry.html">密碼更改</a>
                    </li>
                    <li>
                      <a href="all_restaurants_map_listing.html"
                        >訂單查詢修改</a
                      >
                    </li>
                    <li>
                      <a href="single_restaurant.html">聊天室</a>
                    </li>
                    <li>
                      <a href="payment_restaurant.html">討論區</a>
                    </li>
                  </ul>
                </li>
              </ul>
            </div>
            <!-- End main-menu -->
            <ul id="top_tools">
              <li>
                <div class="dropdown dropdown-cart">
                  <a href="#" data-bs-toggle="dropdown" class="cart_bt"
                    ><i class="icon_bag_alt"></i><strong>3</strong></a
                  >
                  <ul class="dropdown-menu" id="cart_items">
                    <li>
                      <div class="image">
                        <img
                          src="<%=request.getContextPath()%>/Cart/html/img/thumb_cart_1.jpg"
                          alt="image"
                        />
                      </div>
                      <strong><a href="#">Louvre museum</a>1x $36.00 </strong>
                      <a href="#" class="action"><i class="icon-trash"></i></a>
                    </li>
                    <li>
                      <div class="image">
                        <img
                          src="<%=request.getContextPath()%>/Cart/html/img/thumb_cart_2.jpg"
                          alt="image"
                        />
                      </div>
                      <strong><a href="#">Versailles tour</a>2x $36.00 </strong>
                      <a href="#" class="action"><i class="icon-trash"></i></a>
                    </li>
                    <li>
                      <div class="image">
                        <img
                          src="<%=request.getContextPath()%>/Cart/html/img/thumb_cart_3.jpg"
                          alt="image"
                        />
                      </div>
                      <strong><a href="#">Versailles tour</a>1x $36.00 </strong>
                      <a href="#" class="action"><i class="icon-trash"></i></a>
                    </li>
                    <li>
                      <div>Total: <span>$120.00</span></div>
                      <a href="cart.html" class="button_drop">Go to cart</a>
                      <a href="payment.html" class="button_drop outline"
                        >Check out</a
                      >
                    </li>
                  </ul>
                </div>
                <!-- End dropdown-cart-->
              </li>
            </ul>
          </nav>
        </div>
      </div>
      <!-- container -->
    </header>
    <!-- End Header -->
    <div class="container">
      <div class="row" style="margin-top: 12%">
        <div class="col-3">
          <select name="" id="first">
            <c:forEach var="result" items="${result}">
              <option value="${result.cruiseLineNo }">
                ${result.cruiseLines }
              </option>
            </c:forEach>
          </select>
          <select name="" id="second"></select>
        </div>
      </div>
      <div class="row">
        <div class="col-6">
          <div id="map" class="map"></div>
        </div>
        <div class="col-6">
          <div class="mpa_list">
            <ul
              id="maplist"
              style="list-style: none; height: 100%; overflow: auto"
            >
              <li style="list-style: none" class="port18">
                <img
                  src="<%=request.getContextPath()%>/images/map1.png"
                  style="width: 70%"
                  alt=""
                />
                <button
                  class="btn btn_change"
                  style="height: 100%; width: 25%; background-color: #bbcfe2"
                  data-hr=".letmeopen"
                >
                  變更
                </button>
                <div class="popup-wrap letmeopen port18">
                  <div class="popup-box transform-out" data-port="port18">
                    <button class="btn_back"><h3>原本</h3></button>
                    <button class="btn_rest port18">餐廳</button>
                    <button class="btn_mark">景點</button>
                    <button class="btn_act">活動</button>
                    <a class="close-btn popup-close" href="#">x</a>
                  </div>
                </div>
              </li>
              <li style="list-style: none" class="port19">
                <img
                  src="<%=request.getContextPath()%>/images/sightseeing4.png"
                  style="width: 70%"
                  alt=""
                />
                <button
                  class="btn btn_change"
                  style="height: 100%; width: 25%; background-color: #bbcfe2"
                  data-hr=".letmeopen"
                >
                  變更
                </button>
                <div class="popup-wrap letmeopen">
                  <div class="popup-box transform-out" data-port="port19">
                    <button class="btn_back"><h3>原本</h3></button>
                    <button class="btn_rest port19">餐廳</button>
                    <button class="btn_mark">景點</button>
                    <button class="btn_act">活動</button>
                    <a class="close-btn popup-close" href="#">x</a>
                  </div>
                </div>
              </li>
              <li style="list-style: none" class="port20">
                <img
                  src="<%=request.getContextPath()%>/images/sightseeing3.png"
                  style="width: 70%"
                  alt=""
                />
                <button
                  class="btn btn_change"
                  style="height: 100%; width: 25%; background-color: #bbcfe2"
                  data-hr=".letmeopen"
                >
                  變更
                </button>
                <div class="popup-wrap letmeopen">
                  <div class="popup-box transform-out" data-port="port20">
                    <button class="btn_back"><h3>原本</h3></button>
                    <button class="btn_rest port19">餐廳</button>
                    <button class="btn_mark">景點</button>
                    <button class="btn_act">活動</button>
                    <a class="close-btn popup-close" href="#">x</a>
                  </div>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <!--       <div class="row wearherTitle"></div> -->
      <div class="row">
        <div class="col-4 like_title">
          <ul>
            <p>想去的餐廳</p>
          </ul>
        </div>
        <div class="col-4 like_title">
          <ul>
            <p>想去的景點</p>
          </ul>
        </div>
        <div class="col-4 like_title">
          <ul>
            <p>想去的活動</p>
          </ul>
        </div>
        <div class="col-4 like_content">
          <ul class="rest"></ul>
        </div>
        <div class="col-4 like_content">
          <ul class="mark"></ul>
        </div>
        <div class="col-4 like_content">
          <ul class="act"></ul>
        </div>
      </div>
    </div>
    <footer>
      <div class="container">
        <!-- End row -->
        <div class="row">
          <div class="col-md-12">
            <div id="social_footer">
              <p>© Pandora 2022</p>
            </div>
          </div>
        </div>
        <!-- End row -->
      </div>
      <!-- End container -->
    </footer>
    <!-- Search Menu -->
    <div class="search-overlay-menu">
      <span class="search-overlay-close"
        ><i class="icon_set_1_icon-77"></i
      ></span>
      <form role="search" id="searchform" method="get">
        <input value="" name="q" type="text" placeholder="Search..." />
        <button type="submit"><i class="icon_set_1_icon-78"></i></button>
      </form>
    </div>
    <!-- End Search Menu -->

    <!-- Sign In Popup -->
    <div id="sign-in-dialog" class="zoom-anim-dialog mfp-hide">
      <div class="small-dialog-header">
        <h3>Sign In</h3>
      </div>
      <form>
        <div class="sign-in-wrapper">
          <a href="#0" class="social_bt facebook">Login with Facebook</a>
          <a href="#0" class="social_bt google">Login with Google</a>
          <div class="divider"><span>Or</span></div>
          <div class="form-group">
            <label>Email</label>
            <input type="email" class="form-control" name="email" id="email" />
            <i class="icon_mail_alt"></i>
          </div>
          <div class="form-group">
            <label>Password</label>
            <input
              type="password"
              class="form-control"
              name="password"
              id="password"
              value=""
            />
            <i class="icon_lock_alt"></i>
          </div>
          <div class="clearfix add_bottom_15">
            <div class="checkboxes float-start">
              <label class="container_check"
                >Remember me
                <input type="checkbox" />
                <span class="checkmark"></span>
              </label>
            </div>
            <div class="float-end">
              <a id="forgot" href="javascript:void(0);">Forgot Password?</a>
            </div>
          </div>
          <div class="text-center">
            <input type="submit" value="Log In" class="btn_login" />
          </div>
          <div class="text-center">
            Don’t have an account? <a href="javascript:void(0);">Sign up</a>
          </div>
          <div id="forgot_pw">
            <div class="form-group">
              <label>Please confirm login email below</label>
              <input
                type="email"
                class="form-control"
                name="email_forgot"
                id="email_forgot"
              />
              <i class="icon_mail_alt"></i>
            </div>
            <p>
              You will receive an email containing a link allowing you to reset
              your password to a new preferred one.
            </p>
            <div class="text-center">
              <input type="submit" value="Reset Password" class="btn_1" />
            </div>
          </div>
        </div>
      </form>
      <!--form -->
    </div>
    <!-- /Sign In Popup -->

    <footer class="revealed"></footer>

    <!-- Common scripts -->
    <script src="<%=request.getContextPath()%>/Cart/html/js/jquery-3.6.0.min.js"></script>
    <script src="<%=request.getContextPath()%>/Cart/html/js/common_scripts_min.js"></script>
    <script src="<%=request.getContextPath()%>/Cart/html/js/functions.js"></script>
    <!-- Map -->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBaLnCT5X3SOIuBBlEMSlXuFLIh4qLyXxQ&libraries=places"></script>

    <script src="<%=request.getContextPath()%>/front-end/sightseeing/js/map_full_page.js"></script>

    <script src="<%=request.getContextPath()%>/Cart/html/js/infobox.js"></script>
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.27.2/axios.min.js"
      integrity="sha512-odNmoc1XJy5x1TMVMdC7EMs3IVdItLPlCeL5vSUPN2llYKMJ2eByTTAIiiuqLg+GdNr9hF6z81p27DArRFKT7A=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    ></script>
    <script>
      // $.ajax({
      //   url: "http://localhost:8080/pandora/SightseeingServlet", // 資料請求的網址
      //   type: "POST", // GET | POST | PUT | DELETE | PATCH
      //   // data: 物件資料,             // 將物件資料(不用雙引號) 傳送到指定的 url
      //   dataType: "json", // 預期會接收到回傳資料的格式： json | xml | html
      //   success: function (data) {
      //     // request 成功取得回應後執行
      //     console.log(data);
      //   },
      // });
      var first = document.querySelector("#first");

      axios
        .post("http://localhost:8080/pandora/SightseeingServlet")
        .then((response) => {
          // console.log(response);
          // console.log(response.data);

          scv = response.data
            .replace("[", "")
            .replace("]", "")
            .replace("[", ",")
            .replace("]", "")
            .split(",");
          let vo = "<option>請選擇</option>";
          // let vo = "";
          for (i = 0; i < scv.length / 2; i++) {
            // console.log(scv[i]);
            let j = scv.length / 2;
            // if ((i = 0)) {
            //   vo +=
            //     "<option value='" +
            //     scv[j + i] +
            //     "' selected='selected'>" +
            //     scv[i] +
            //     "</option>";
            // } else {
            vo += "<option value='" + scv[j + i] + "'>" + scv[i] + "</option>";
            // }
            // console.log(vo);
          }
          $("select#first").html(vo);
        });
      // console.log(scv);
      // console.log(scv[0]);
      // console.log(scv.length);

      // for (i = scv.length / 2; i < scv.length; i++) {
      // console.log(scv[i]);
      // }
      //   scv.forEach((element) => console.log(element));
      // });
      // fetch("SightseeingServlet", {
      //   method: "POST",
      //   headers: { "Content-Type": "application/json" },
      //   body: JSON.stringify({
      //     // cruiseLineNo: cruiseLineNo.value,
      //     // cruiseLines: cruiseLines.value,
      //   }),
      // }).then((resp) => resp.json());
      // if ($("#first option:selected").val() != null) {
      // console.log($("#first option:selected").val());
      // }
      $("#first").change(function () {
        var item = $("#first  option:selected").val();
        // alert(aaa);
        let url = "http://localhost:8080/pandora/PortSelect";

        // axios
        //   .post(url, { item })
        //   .then((res) => {
        //     console.log(res);
        //   })
        //   .catch((err) => {});
        axios.post(url, { item }).then((response) => {
          // console.log(response.data);
          // console.log(response.data);
          scv = response.data
            .replace("[", "")
            .replace("]", "")
            .replace("[", ",")
            .replace("]", "")
            .split(",");
          let vo = "<option>請選擇</option>";
          // let vo = "";
          for (i = 0; i < scv.length / 2; i++) {
            // console.log(scv[i]);
            let j = scv.length / 2;
            vo +=
              "<option value='" +
              scv[j + i].trim() +
              "'>" +
              scv[i] +
              "</option>";
          }
          $("select#second").html(vo);
        });
      });
      // $("#first").trigger("change");
      $("#second").change(function () {
        var port = $("#second  option:selected").val();
        // console.log(port);
        let url = "http://localhost:8080/pandora/LaLoPicServlet";
        axios.post(url, { port }).then((response) => {
          // console.log(response.data);
          var lalo = response.data.split(" ");
          // console.log(parseFloat(lalo[0]) + " ," + parseFloat(lalo[1]));
          //           console.log(parseFloat(lalo[0]), parseFloat(lalo[1]));
          // console.log(parseFloat(lalo[0]), parseFloat(lalo[1]));
          // console.log(lalo[2][0], lalo[2][1], lalo[2][2]);
          // console.log(lalo[2]);
          // console.log(lalo[3]);
          // console.log(lalo[4]);
          let sss = "";
          for (i = 2; i < lalo.length; i++) {
            sss +=
              "<li style='list-style: none'>" +
              "<img src='" +
              lalo[i] +
              "' style='width: 70%' alt=''/>" +
              "<button class='btn btn_change' style='height: 100%; width: 25%; background-color: #bbcfe2' data-hr='.letmeopen'>" +
              "變更</button>" +
              "<div class='popup-wrap letmeopen'>" +
              "<div class='popup-box transform-out'>" +
              " <button class='btn_back'><h3>原本</h3></button>" +
              "<button class='btn_rest'>餐廳</button>" +
              "<button class='btn_mark'>景點</button>" +
              "<button class='btn_act'>活動</button>" +
              "<a class='close-btn popup-close' href='#'>x</a>" +
              " </div> </div> </li>";
          }
          $("ul#maplist").html(sss);
          $(".rest").html("");
          $(".mark").html("");
          $(".act").html("");
          //加入位置
          var mapOptions = {
            zoom: 16,
            //             center: new google.maps.LatLng(24.288734,120.508477),
            center: new google.maps.LatLng(
              parseFloat(lalo[0]),
              parseFloat(lalo[1])
            ),
            mapTypeId: google.maps.MapTypeId.ROADMAP,

            mapTypeControl: false,
            mapTypeControlOptions: {
              style: google.maps.MapTypeControlStyle.DROPDOWN_MENU,
              position: google.maps.ControlPosition.LEFT_CENTER,
            },
            panControl: false,
            panControlOptions: {
              position: google.maps.ControlPosition.TOP_RIGHT,
            },
            zoomControl: true,
            zoomControlOptions: {
              style: google.maps.ZoomControlStyle.LARGE,
              position: google.maps.ControlPosition.LEFT_CENTER,
            },
            scrollwheel: false,
            scaleControl: false,
            scaleControlOptions: {
              position: google.maps.ControlPosition.LEFT_CENTER,
            },
            streetViewControl: true,
            streetViewControlOptions: {
              position: google.maps.ControlPosition.LEFT_CENTER,
            },
            styles: [
              {
                featureType: "administrative.country",
                elementType: "all",
                stylers: [
                  {
                    visibility: "off",
                  },
                ],
              },
              {
                featureType: "administrative.province",
                elementType: "all",
                stylers: [
                  {
                    visibility: "off",
                  },
                ],
              },
              {
                featureType: "administrative.locality",
                elementType: "all",
                stylers: [
                  {
                    visibility: "off",
                  },
                ],
              },
              {
                featureType: "administrative.neighborhood",
                elementType: "all",
                stylers: [
                  {
                    visibility: "off",
                  },
                ],
              },
              {
                featureType: "administrative.land_parcel",
                elementType: "all",
                stylers: [
                  {
                    visibility: "off",
                  },
                ],
              },
              {
                featureType: "landscape.man_made",
                elementType: "all",
                stylers: [
                  {
                    visibility: "simplified",
                  },
                ],
              },
              {
                featureType: "landscape.natural.landcover",
                elementType: "all",
                stylers: [
                  {
                    visibility: "on",
                  },
                ],
              },
              {
                featureType: "landscape.natural.terrain",
                elementType: "all",
                stylers: [
                  {
                    visibility: "off",
                  },
                ],
              },
              {
                featureType: "poi.attraction",
                elementType: "all",
                stylers: [
                  {
                    visibility: "on",
                  },
                ],
              },
              {
                featureType: "poi.business",
                elementType: "all",
                stylers: [
                  {
                    visibility: "on",
                  },
                ],
              },
              {
                featureType: "poi.government",
                elementType: "all",
                stylers: [
                  {
                    visibility: "off",
                  },
                ],
              },
              {
                featureType: "poi.medical",
                elementType: "all",
                stylers: [
                  {
                    visibility: "on",
                  },
                ],
              },
              {
                featureType: "poi.park",
                elementType: "all",
                stylers: [
                  {
                    visibility: "on",
                  },
                ],
              },
              {
                featureType: "poi.park",
                elementType: "labels",
                stylers: [
                  {
                    visibility: "on",
                  },
                ],
              },
              {
                featureType: "poi.place_of_worship",
                elementType: "all",
                stylers: [
                  {
                    visibility: "on",
                  },
                ],
              },
              {
                featureType: "poi.school",
                elementType: "all",
                stylers: [
                  {
                    visibility: "off",
                  },
                ],
              },
              {
                featureType: "poi.sports_complex",
                elementType: "all",
                stylers: [
                  {
                    visibility: "on",
                  },
                ],
              },
              {
                featureType: "road.highway",
                elementType: "all",
                stylers: [
                  {
                    visibility: "off",
                  },
                ],
              },
              {
                featureType: "road.highway",
                elementType: "labels",
                stylers: [
                  {
                    visibility: "off",
                  },
                ],
              },
              {
                featureType: "road.highway.controlled_access",
                elementType: "all",
                stylers: [
                  {
                    visibility: "off",
                  },
                ],
              },
              {
                featureType: "road.arterial",
                elementType: "all",
                stylers: [
                  {
                    visibility: "simplified",
                  },
                ],
              },
              {
                featureType: "road.local",
                elementType: "all",
                stylers: [
                  {
                    visibility: "simplified",
                  },
                ],
              },
              {
                featureType: "transit.line",
                elementType: "all",
                stylers: [
                  {
                    visibility: "off",
                  },
                ],
              },
              {
                featureType: "transit.station.airport",
                elementType: "all",
                stylers: [
                  {
                    visibility: "on",
                  },
                ],
              },
              {
                featureType: "transit.station.bus",
                elementType: "all",
                stylers: [
                  {
                    visibility: "on",
                  },
                ],
              },
              {
                featureType: "transit.station.rail",
                elementType: "all",
                stylers: [
                  {
                    visibility: "on",
                  },
                ],
              },
              {
                featureType: "water",
                elementType: "all",
                stylers: [
                  {
                    visibility: "on",
                  },
                ],
              },
              {
                featureType: "water",
                elementType: "labels",
                stylers: [
                  {
                    visibility: "off",
                  },
                ],
              },
            ],
          };
          // console.log(parseFloat(lalo[0]) + " ," + parseFloat(lalo[1]));
          var marker;
          mapObject = new google.maps.Map(
            document.getElementById("map"),
            mapOptions
          );
          //加入位置
        });
      });
      // $("#maplist").on("click", "button.btm_change", function () {
      //   let af = $(this).parent("li");
      //   $(".act").append(af);
      // });
      $("#maplist").on("click", "button.btn_change", function (e) {
        // console.log("test");
        // console.log(e.target.parentNode);
        var af = $(this).closest("li");
        let href = $(this).attr("data-hr");
        // console.log(this);
        // console.log(this.closest("li"));

        // let cc = $(this).closest("div.port18");
        // let ccc = $(this).next();
        // console.log(cc);
        // console.log(ccc);
        // console.log(cc.find("div.port18"));
        $(this).next().fadeIn(250);
        $(this)
          .next()
          .children("popup-box")
          .removeClass("transform-out")
          .addClass("transform-in");
        // e.preventDefault();
        $(this).next().attr("data", af);
      });
      $(".popup-close").click(function () {
        closeWindow();
        event.preventDefault();
      });
      $("#maplist").on("click", "a", function (e) {
        closeWindow();
        event.preventDefault();
      });
      $(".rest").on("click", "a", function (e) {
        closeWindow();
        event.preventDefault();
      });
      $(".mark").on("click", "a", function (e) {
        closeWindow();
        event.preventDefault();
      });
      $(".act").on("click", "a", function (e) {
        closeWindow();
        event.preventDefault();
      });
      function closeWindow() {
        $(".popup-wrap").fadeOut(200);
        $(".popup-box").removeClass("transform-in").addClass("transform-out");
        event.preventDefault();
      }
      $("#maplist").on("click", "button.btn_rest", function () {
        let v = this.closest("li");
        // console.log(v);
        var af = $(this).closest("li").clone();
        let v2 = "maplist" + v;
        // console.log($(v2).clone());
        // console.log(af);
        // console.log(this);
        // console.log(this.closest("div").dataset.port);
        $(".rest").append(af);
        $(this).closest("li").remove();
        closeWindow();
      });
      $("#maplist").on("click", "button.btn_back", function () {
        var af = $(this).closest("li").clone();
        $("#maplist").append(af);
        $(this).closest("li").remove();
        closeWindow();
      });
      $("#maplist").on("click", "button.btn_mark", function () {
        var af = $(this).closest("li").clone();
        $(".mark").append(af);
        $(this).closest("li").remove();
        closeWindow();
      });
      $("#maplist").on("click", "button.btn_act", function () {
        var af = $(this).closest("li").clone();
        $(".act").append(af);
        $(this).closest("li").remove();
        closeWindow();
      });
      $(".rest").on("click", "button.btn_change", function () {
        var af = $(this).closest("li");
        let href = $(this).attr("data-hr");
        console.log(af);
        $(this).next().fadeIn(250);
        $(this)
          .next()
          .children("popup-box")
          .removeClass("transform-out")
          .addClass("transform-in");
        // e.preventDefault();
        $(this).next().attr("data", af);
      });
      $(".rest").on("click", "button.btn_back", function () {
        var af = $(this).closest("li").clone();
        $("#maplist").append(af);
        $(this).closest("li").remove();
        closeWindow();
      });
      $(".rest").on("click", "button.btn_rest", function () {
        var af = $(this).closest("li").clone();
        $(".rest").append(af);
        $(this).closest("li").remove();
        closeWindow();
      });
      $(".rest").on("click", "button.btn_mark", function () {
        var af = $(this).closest("li").clone();
        $(".mark").append(af);
        $(this).closest("li").remove();
        closeWindow();
      });
      $(".rest").on("click", "button.btn_act", function () {
        var af = $(this).closest("li").clone();
        $(".act").append(af);
        $(this).closest("li").remove();
        closeWindow();
      });
      $(".mark").on("click", "button.btn_change", function () {
        var af = $(this).closest("li");
        let href = $(this).attr("data-hr");
        console.log(af);
        $(this).next().fadeIn(250);
        $(this)
          .next()
          .children("popup-box")
          .removeClass("transform-out")
          .addClass("transform-in");
        // e.preventDefault();
        $(this).next().attr("data", af);
      });
      $(".mark").on("click", "button.btn_back", function () {
        var af = $(this).closest("li").clone();
        $("#maplist").append(af);
        $(this).closest("li").remove();
        closeWindow();
      });
      $(".mark").on("click", "button.btn_rest", function () {
        var af = $(this).closest("li").clone();
        $(".rest").append(af);
        $(this).closest("li").remove();
        closeWindow();
      });
      $(".mark").on("click", "button.btn_mark", function () {
        var af = $(this).closest("li").clone();
        $(".mark").append(af);
        $(this).closest("li").remove();
        closeWindow();
      });
      $(".mark").on("click", "button.btn_act", function () {
        var af = $(this).closest("li").clone();
        $(".act").append(af);
        $(this).closest("li").remove();
        closeWindow();
      });
      $(".act").on("click", "button.btn_change", function () {
        var af = $(this).closest("li");
        let href = $(this).attr("data-hr");
        console.log(af);
        $(this).next().fadeIn(250);
        $(this)
          .next()
          .children("popup-box")
          .removeClass("transform-out")
          .addClass("transform-in");
        // e.preventDefault();
        $(this).next().attr("data", af);
      });
      $(".act").on("click", "button.btn_back", function () {
        var af = $(this).closest("li").clone();
        $("#maplist").append(af);
        $(this).closest("li").remove();
        closeWindow();
      });
      $(".act").on("click", "button.btn_rest", function () {
        var af = $(this).closest("li").clone();
        $(".rest").append(af);
        $(this).closest("li").remove();
        closeWindow();
      });
      $(".act").on("click", "button.btn_mark", function () {
        var af = $(this).closest("li").clone();
        $(".mark").append(af);
        $(this).closest("li").remove();
        closeWindow();
      });
      $(".act").on("click", "button.btn_act", function () {
        var af = $(this).closest("li").clone();
        $(".act").append(af);
        $(this).closest("li").remove();
        closeWindow();
      });
      // $("#maplist button").on("click", function (e) {
      //   console.log("test");
      //   console.log(e.target);
      // });
    </script>
  </body>
</html>
