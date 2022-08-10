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
              style="list-style: none; overflow-y: auto; height: 100%"
            >
              <!-- 測驗組 -->

              <!-- <li style="list-style: none" class="port18">
                <img
                  src="<%=request.getContextPath()%>/images/map1.png"
                  style="width: 70%"
                  alt=""
                />

                <select id="change1">
                  <option value="0">請選擇</option>
                  <option value="1">餐廳</option>
                  <option value="2">景點</option>
                  <option value="3">活動</option>
                  <option value="4">回復</option>
                </select>
              </li>
              <li style="list-style: none" class="port19">
                <img
                  src="<%=request.getContextPath()%>/images/sightseeing4.png"
                  style="width: 70%"
                  alt=""
                />
                <select id="change2">
                  <option value="0">請選擇</option>
                  <option value="1">餐廳</option>
                  <option value="2">景點</option>
                  <option value="3">活動</option>
                  <option value="4">回復</option>
                </select>
              </li>
              <li style="list-style: none" class="port20">
                <img
                  src="<%=request.getContextPath()%>/images/sightseeing3.png"
                  style="width: 70%"
                  alt=""
                />
                <select id="change3">
                  <option value="0">請選擇</option>
                  <option value="1">餐廳</option>
                  <option value="2">景點</option>
                  <option value="3">活動</option>
                  <option value="4">回復</option>
                </select>
              </li> -->

              <!-- 測驗組 -->
            </ul>
          </div>
        </div>
      </div>
      <div class="row wearherTitle"></div>
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
      //#change1
      $("#change1").change(function () {
        var item = $("#change1  option:selected").val();
        // console.log(item);
        // console.log(this);
        if (item == 1) {
          var af = $(this).closest("li").clone();
          $(".rest").append(af);
          $(this).closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).closest("li").clone();
          $(".mark").append(af);
          $(this).closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).closest("li").clone();
          $(".act").append(af);
          $(this).closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).closest("li").clone();
          $("#maplist").append(af);
          $(this).closest("li").remove();
        }
      });
      $(".rest").change("#change1  option:selected", function () {
        var item = $("#change1  option:selected").val();
        // console.log(item);
        // console.log(this.find("#change1"));
        if (item == 1) {
          var af = $(this).find("#change1").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change1").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change1").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change1").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change1").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change1").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change1").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change1").closest("li").remove();
        }
      });
      $(".mark").change("#change1  option:selected", function () {
        var item = $("#change1  option:selected").val();
        // console.log(item);
        // console.log(this.find("#change1"));
        if (item == 1) {
          var af = $(this).find("#change1").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change1").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change1").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change1").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change1").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change1").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change1").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change1").closest("li").remove();
        }
      });
      $(".act").change("#change1  option:selected", function () {
        var item = $("#change1  option:selected").val();
        // console.log(item);
        // console.log(this.find("#change1"));
        if (item == 1) {
          var af = $(this).find("#change1").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change1").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change1").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change1").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change1").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change1").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change1").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change1").closest("li").remove();
        }
      });
      $("#maplist").change("#change1  option:selected", function () {
        var item = $("#change1  option:selected").val();
        // console.log(item);
        // console.log(this.find("#change1"));
        if (item == 1) {
          var af = $(this).find("#change1").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change1").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change1").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change1").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change1").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change1").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change1").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change1").closest("li").remove();
        }
      });
      //#change1

      //#change2
      $("#change2").change(function () {
        var item = $("#change2  option:selected").val();
        if (item == 1) {
          var af = $(this).closest("li").clone();
          $(".rest").append(af);
          $(this).closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).closest("li").clone();
          $(".mark").append(af);
          $(this).closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).closest("li").clone();
          $(".act").append(af);
          $(this).closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).closest("li").clone();
          $("#maplist").append(af);
          $(this).closest("li").remove();
        }
      });
      $(".rest").change("#change2  option:selected", function () {
        var item = $("#change2  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change2").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change2").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change2").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change2").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change2").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change2").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change2").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change2").closest("li").remove();
        }
      });
      $(".mark").change("#change2  option:selected", function () {
        var item = $("#change2  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change2").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change2").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change2").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change2").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change2").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change2").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change2").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change2").closest("li").remove();
        }
      });
      $(".act").change("#change2  option:selected", function () {
        var item = $("#change2  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change2").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change2").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change2").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change2").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change2").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change2").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change2").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change2").closest("li").remove();
        }
      });
      $("#maplist").change("#change2  option:selected", function () {
        var item = $("#change2  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change2").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change2").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change2").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change2").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change2").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change2").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change2").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change2").closest("li").remove();
        }
      });
      //#change2

      //#change3
      $("#change3").change(function () {
        var item = $("#change3  option:selected").val();
        if (item == 1) {
          var af = $(this).closest("li").clone();
          $(".rest").append(af);
          $(this).closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).closest("li").clone();
          $(".mark").append(af);
          $(this).closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).closest("li").clone();
          $(".act").append(af);
          $(this).closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).closest("li").clone();
          $("#maplist").append(af);
          $(this).closest("li").remove();
        }
      });
      $(".rest").change("#change3  option:selected", function () {
        var item = $("#change3  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change3").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change3").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change3").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change3").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change3").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change3").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change3").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change3").closest("li").remove();
        }
      });
      $(".mark").change("#change3  option:selected", function () {
        var item = $("#change3  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change3").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change3").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change3").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change3").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change3").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change3").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change3").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change3").closest("li").remove();
        }
      });
      $(".act").change("#change3  option:selected", function () {
        var item = $("#change3  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change3").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change3").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change3").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change3").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change3").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change3").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change3").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change3").closest("li").remove();
        }
      });
      $("#maplist").change("#change3  option:selected", function () {
        var item = $("#change3  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change3").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change3").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change3").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change3").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change3").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change3").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change3").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change3").closest("li").remove();
        }
      });
      //#change3

      //#change4
      $("#change4").change(function () {
        var item = $("#change4  option:selected").val();
        if (item == 1) {
          var af = $(this).closest("li").clone();
          $(".rest").append(af);
          $(this).closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).closest("li").clone();
          $(".mark").append(af);
          $(this).closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).closest("li").clone();
          $(".act").append(af);
          $(this).closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).closest("li").clone();
          $("#maplist").append(af);
          $(this).closest("li").remove();
        }
      });
      $(".rest").change("#change4  option:selected", function () {
        var item = $("#change4  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change4").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change4").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change4").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change4").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change4").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change4").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change4").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change4").closest("li").remove();
        }
      });
      $(".mark").change("#change4  option:selected", function () {
        var item = $("#change4  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change4").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change4").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change4").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change4").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change4").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change4").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change4").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change4").closest("li").remove();
        }
      });
      $(".act").change("#change4  option:selected", function () {
        var item = $("#change4  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change4").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change4").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change4").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change4").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change4").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change4").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change4").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change4").closest("li").remove();
        }
      });
      $("#maplist").change("#change4  option:selected", function () {
        var item = $("#change4  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change4").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change4").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change4").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change4").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change4").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change4").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change4").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change4").closest("li").remove();
        }
      });
      //#change4

      //#change5
      $("#change5").change(function () {
        var item = $("#change5  option:selected").val();
        if (item == 1) {
          var af = $(this).closest("li").clone();
          $(".rest").append(af);
          $(this).closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).closest("li").clone();
          $(".mark").append(af);
          $(this).closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).closest("li").clone();
          $(".act").append(af);
          $(this).closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).closest("li").clone();
          $("#maplist").append(af);
          $(this).closest("li").remove();
        }
      });
      $(".rest").change("#change5  option:selected", function () {
        var item = $("#change5  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change5").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change5").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change5").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change5").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change5").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change5").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change5").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change5").closest("li").remove();
        }
      });
      $(".mark").change("#change5  option:selected", function () {
        var item = $("#change5  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change5").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change5").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change5").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change5").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change5").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change5").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change5").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change5").closest("li").remove();
        }
      });
      $(".act").change("#change5  option:selected", function () {
        var item = $("#change5  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change5").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change5").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change5").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change5").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change5").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change5").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change5").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change5").closest("li").remove();
        }
      });
      $("#maplist").change("#change5  option:selected", function () {
        var item = $("#change5  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change5").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change5").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change5").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change5").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change5").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change5").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change5").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change5").closest("li").remove();
        }
      });
      //#change5

      //#change6
      $("#change6").change(function () {
        var item = $("#change6  option:selected").val();
        if (item == 1) {
          var af = $(this).closest("li").clone();
          $(".rest").append(af);
          $(this).closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).closest("li").clone();
          $(".mark").append(af);
          $(this).closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).closest("li").clone();
          $(".act").append(af);
          $(this).closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).closest("li").clone();
          $("#maplist").append(af);
          $(this).closest("li").remove();
        }
      });
      $(".rest").change("#change6  option:selected", function () {
        var item = $("#change6  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change6").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change6").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change6").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change6").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change6").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change6").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change6").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change6").closest("li").remove();
        }
      });
      $(".mark").change("#change6  option:selected", function () {
        var item = $("#change6  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change6").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change6").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change6").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change6").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change6").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change6").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change6").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change6").closest("li").remove();
        }
      });
      $(".act").change("#change6  option:selected", function () {
        var item = $("#change6  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change6").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change6").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change6").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change6").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change6").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change6").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change6").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change6").closest("li").remove();
        }
      });
      $("#maplist").change("#change6  option:selected", function () {
        var item = $("#change6  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change6").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change6").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change6").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change6").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change6").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change6").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change6").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change6").closest("li").remove();
        }
      });
      //#change6

      //#change7
      $("#change7").change(function () {
        var item = $("#change7  option:selected").val();
        if (item == 1) {
          var af = $(this).closest("li").clone();
          $(".rest").append(af);
          $(this).closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).closest("li").clone();
          $(".mark").append(af);
          $(this).closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).closest("li").clone();
          $(".act").append(af);
          $(this).closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).closest("li").clone();
          $("#maplist").append(af);
          $(this).closest("li").remove();
        }
      });
      $(".rest").change("#change7  option:selected", function () {
        var item = $("#change7  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change7").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change7").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change7").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change7").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change7").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change7").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change7").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change7").closest("li").remove();
        }
      });
      $(".mark").change("#change7  option:selected", function () {
        var item = $("#change7  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change7").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change7").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change7").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change7").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change7").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change7").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change7").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change7").closest("li").remove();
        }
      });
      $(".act").change("#change7  option:selected", function () {
        var item = $("#change7  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change7").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change7").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change7").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change7").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change7").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change7").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change7").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change7").closest("li").remove();
        }
      });
      $("#maplist").change("#change7  option:selected", function () {
        var item = $("#change7  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change7").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change7").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change7").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change7").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change7").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change7").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change7").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change7").closest("li").remove();
        }
      });
      //#change7

      //#change8
      $("#change8").change(function () {
        var item = $("#change8  option:selected").val();
        if (item == 1) {
          var af = $(this).closest("li").clone();
          $(".rest").append(af);
          $(this).closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).closest("li").clone();
          $(".mark").append(af);
          $(this).closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).closest("li").clone();
          $(".act").append(af);
          $(this).closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).closest("li").clone();
          $("#maplist").append(af);
          $(this).closest("li").remove();
        }
      });
      $(".rest").change("#change8  option:selected", function () {
        var item = $("#change8  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change8").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change8").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change8").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change8").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change8").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change8").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change8").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change8").closest("li").remove();
        }
      });
      $(".mark").change("#change8  option:selected", function () {
        var item = $("#change8  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change8").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change8").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change8").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change8").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change8").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change8").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change8").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change8").closest("li").remove();
        }
      });
      $(".act").change("#change8  option:selected", function () {
        var item = $("#change8  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change8").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change8").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change8").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change8").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change8").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change8").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change8").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change8").closest("li").remove();
        }
      });
      $("#maplist").change("#change8  option:selected", function () {
        var item = $("#change8  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change8").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change8").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change8").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change8").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change8").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change8").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change8").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change8").closest("li").remove();
        }
      });
      //#change8

      //#change9
      $("#change9").change(function () {
        var item = $("#change9  option:selected").val();
        if (item == 1) {
          var af = $(this).closest("li").clone();
          $(".rest").append(af);
          $(this).closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).closest("li").clone();
          $(".mark").append(af);
          $(this).closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).closest("li").clone();
          $(".act").append(af);
          $(this).closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).closest("li").clone();
          $("#maplist").append(af);
          $(this).closest("li").remove();
        }
      });
      $(".rest").change("#change9  option:selected", function () {
        var item = $("#change9  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change9").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change9").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change9").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change9").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change9").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change9").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change9").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change9").closest("li").remove();
        }
      });
      $(".mark").change("#change9  option:selected", function () {
        var item = $("#change9  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change9").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change9").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change9").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change9").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change9").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change9").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change9").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change9").closest("li").remove();
        }
      });
      $(".act").change("#change9  option:selected", function () {
        var item = $("#change9  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change9").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change9").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change9").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change9").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change9").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change9").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change9").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change9").closest("li").remove();
        }
      });
      $("#maplist").change("#change9  option:selected", function () {
        var item = $("#change9  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change9").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change9").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change9").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change9").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change9").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change9").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change9").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change9").closest("li").remove();
        }
      });
      //#change9

      //#change10
      $("#change10").change(function () {
        var item = $("#change10  option:selected").val();
        if (item == 1) {
          var af = $(this).closest("li").clone();
          $(".rest").append(af);
          $(this).closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).closest("li").clone();
          $(".mark").append(af);
          $(this).closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).closest("li").clone();
          $(".act").append(af);
          $(this).closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).closest("li").clone();
          $("#maplist").append(af);
          $(this).closest("li").remove();
        }
      });
      $(".rest").change("#change10  option:selected", function () {
        var item = $("#change10  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change10").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change10").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change10").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change10").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change10").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change10").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change10").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change10").closest("li").remove();
        }
      });
      $(".mark").change("#change10  option:selected", function () {
        var item = $("#change10  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change10").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change10").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change10").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change10").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change10").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change10").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change10").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change10").closest("li").remove();
        }
      });
      $(".act").change("#change10  option:selected", function () {
        var item = $("#change10  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change10").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change10").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change10").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change10").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change10").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change10").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change10").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change10").closest("li").remove();
        }
      });
      $("#maplist").change("#change10  option:selected", function () {
        var item = $("#change10  option:selected").val();
        if (item == 1) {
          var af = $(this).find("#change10").closest("li").clone();
          $(".rest").append(af);
          $(this).find("#change10").closest("li").remove();
        }
        if (item == 2) {
          var af = $(this).find("#change10").closest("li").clone();
          $(".mark").append(af);
          $(this).find("#change10").closest("li").remove();
        }
        if (item == 3) {
          var af = $(this).find("#change10").closest("li").clone();
          $(".act").append(af);
          $(this).find("#change10").closest("li").remove();
        }
        if (item == 4) {
          var af = $(this).find("#change10").closest("li").clone();
          $("#maplist").append(af);
          $(this).find("#change10").closest("li").remove();
        }
      });
      //#change10
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
        //天氣
        switch (port) {
          case "1":
            // console.log(port);
            axios
              .get(
                "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-D0047-051?Authorization=CWB-7B427A7B-6E43-41EE-9DCA-8CE82754A1E7&limit=1&offset=4&format=JSON&elementName=&sort=time"
              )
              .then((response) => {
                // data = json.loads(response.text);
                weather(response);
              });
            break;
          case "2":
            // console.log(port);
            axios
              .get(
                "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-D0047-075?Authorization=CWB-7B427A7B-6E43-41EE-9DCA-8CE82754A1E7&limit=1&offset=28&format=JSON&elementName=&sort=time"
              )
              .then((response) => {
                // data = json.loads(response.text);
                weather(response);
              });
            break;
          case "3":
            // console.log(port);
            axios
              .get(
                "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-D0047-067?Authorization=CWB-7B427A7B-6E43-41EE-9DCA-8CE82754A1E7&limit=1&offset=24&format=JSON&elementName=&sort=time"
              )
              .then((response) => {
                // data = json.loads(response.text);
                weather(response);
              });
            break;
          case "4":
            // console.log(port);
            axios
              .get(
                "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-D0047-043?Authorization=CWB-7B427A7B-6E43-41EE-9DCA-8CE82754A1E7&limit=1&offset=2&format=JSON&elementName=&sort=time"
              )
              .then((response) => {
                // data = json.loads(response.text);
                weather(response);
              });
            break;
        }
        //天氣
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
              "<select id='change" +
              (i - 1) +
              "'>" +
              "<option value='0'>請選擇</option>" +
              "<option value='1'>餐廳</option>" +
              "<option value='2'>景點</option>" +
              "<option value='3'>活動</option>" +
              "<option value='4'>回復</option>" +
              "</select></li>";
            i + 1;
          }
          $("ul#maplist").html(sss);
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
      function weather(response) {
        let cc = response.data.records.locations[0].location[0].weatherElement;
        // console.log(cc);
        // console.log(cc[1].time[14].elementValue[0].value);
        // console.log(cc[9]);
        // console.log(cc[6].time[4].startTime.split(" "));
        // console.log(cc[6].time[2].elementValue[0].value);
        let sc = "";
        // if (cc[6].time[2].elementValue[0].value === "晴時多雲") {
        //   console.log(1);
        // }
        // var hs;
        for (let i = 0; i < 12; i++) {
          // if (cc[6].time[2].elementValue[0].value === "晴時多雲") {
          //   var hs =
          //     "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/03.svg'>";
          // }
          switch (cc[6].time[2].elementValue[0].value) {
            case "晴天":
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/01.svg'>";
              break;
            case "晴時多雲":
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/02.svg'>";
              break;
            case "多雲時晴":
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/03.svg'>";
              break;
            case "多雲":
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/04.svg'>";
              break;
            case "多雲時陰":
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/05.svg'>";
              break;
            case "陰時多雲":
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/06.svg'>";
              break;
            case "陰天":
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/07.svg'>";
              break;
            case ("多雲陣雨",
            "多雲短暫雨",
            "多雲短暫陣雨",
            "午後短暫陣雨",
            "短暫陣雨",
            "多雲時晴短暫陣雨",
            "多雲時晴短暫雨",
            "晴時多雲短暫陣雨",
            "晴短暫陣雨",
            "短暫雨"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/08.svg'>";
              break;
            case ("多雲時陰短暫雨", "多雲時陰短暫陣雨"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/09.svg'>";
              break;
            case ("陰時多雲短暫雨", "陰時多雲短暫陣雨"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/010.svg'>";
              break;
            case ("雨天",
            "晴午後陰短暫雨",
            "晴午後陰短暫陣雨",
            "陰短暫雨",
            "陰短暫陣雨",
            "陰午後短暫陣雨"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/11.svg'>";
              break;
            case ("多雲時陰有雨",
            "多雲時陰陣雨",
            "晴時多雲陣雨",
            "多雲時晴陣雨"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/12.svg'>";
              break;
            case ("陰時多雲有雨", "陰時多雲有陣雨", "陰時多雲陣雨"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/13.svg'>";
              break;
            case ("陰有雨",
            "陰有陣雨",
            "陰雨",
            "陰陣雨",
            "陣雨",
            "午後陣雨",
            "有雨"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/14.svg'>";
              break;
            case ("多雲陣雨或雷雨",
            "多雲短暫陣雨或雷雨",
            "多雲短暫雷陣雨",
            "多雲雷陣雨",
            "短暫陣雨或雷雨後多雲",
            "短暫雷陣雨後多雲",
            "短暫陣雨或雷雨",
            "晴時多雲短暫陣雨或雷雨",
            "晴短暫陣雨或雷雨",
            "多雲時晴短暫陣雨或雷雨",
            "午後短暫雷陣雨"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/15.svg'>";
              break;
            case ("多雲時陰陣雨或雷雨",
            "多雲時陰短暫陣雨或雷雨",
            "多雲時陰短暫雷陣雨",
            "多雲時陰雷陣雨",
            "晴陣雨或雷雨",
            "晴時多雲陣雨或雷雨",
            "多雲時晴陣雨或雷雨"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/16.svg'>";
              break;
            case ("陰時多雲有雷陣雨",
            "陰時多雲陣雨或雷雨",
            "陰時多雲短暫陣雨或雷雨",
            "陰時多雲短暫雷陣雨",
            "陰時多雲雷陣雨"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/17.svg'>";
              break;
            case ("陰有陣雨或雷雨",
            "陰有雷陣雨",
            "陰陣雨或雷雨",
            "陰雷陣雨",
            "晴午後陰短暫陣雨或雷雨",
            "晴午後陰短暫雷陣雨",
            "陰短暫陣雨或雷雨",
            "陰短暫雷陣雨",
            "雷雨",
            "陣雨或雷雨後多雲",
            "陰陣雨或雷雨後多雲",
            "陰短暫陣雨或雷雨後多雲",
            "陰短暫雷陣雨後多雲",
            "陰雷陣雨後多雲",
            "雷陣雨後多雲",
            "陣雨或雷雨",
            "雷陣雨",
            "午後雷陣雨"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/18.svg'>";
              break;
            case ("晴午後多雲局部雨",
            "晴午後多雲局部陣雨",
            "晴午後多雲局部短暫雨",
            "晴午後多雲局部短暫陣雨",
            "晴午後多雲短暫雨",
            "晴午後多雲短暫陣雨",
            "晴午後局部雨",
            "晴午後局部陣雨",
            "晴午後局部短暫雨",
            "晴午後局部短暫陣雨",
            "晴午後陣雨",
            "晴午後短暫雨",
            "晴午後短暫陣雨",
            "晴時多雲午後短暫陣雨"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/19.svg'>";
              break;
            case ("多雲午後局部雨",
            "多雲午後局部陣雨",
            "多雲午後局部短暫雨",
            "多雲午後局部短暫陣雨",
            "多雲午後陣雨",
            "多雲午後短暫雨",
            "多雲午後短暫陣雨",
            "多雲時陰午後短暫陣雨",
            "陰時多雲午後短暫陣雨",
            "多雲時晴午後短暫陣雨"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/20.svg'>";
              break;
            case ("晴午後多雲陣雨或雷雨",
            "晴午後多雲雷陣雨",
            "晴午後陣雨或雷雨",
            "晴午後雷陣雨",
            "晴午後多雲局部陣雨或雷雨",
            "晴午後多雲局部短暫陣雨或雷雨",
            "晴午後多雲局部短暫雷陣雨",
            "晴午後多雲局部雷陣雨",
            "晴午後多雲短暫陣雨或雷雨",
            "晴午後多雲短暫雷陣雨",
            "晴午後局部短暫雷陣雨",
            "晴午後局部雷陣雨",
            "晴午後短暫雷陣雨",
            "晴雷陣雨",
            "晴時多雲雷陣雨",
            "晴時多雲午後短暫雷陣雨"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/21.svg'>";
              break;
            case ("多雲午後局部陣雨或雷雨",
            "多雲午後局部短暫陣雨或雷雨",
            "多雲午後局部短暫雷陣雨",
            "多雲午後局部雷陣雨",
            "多雲午後陣雨或雷雨",
            "多雲午後短暫陣雨或雷雨",
            "多雲午後短暫雷陣雨",
            "多雲午後雷陣雨",
            "多雲時晴雷陣雨",
            "多雲時晴午後短暫雷陣雨",
            "多雲時陰午後短暫雷陣雨",
            "陰時多雲午後短暫雷陣雨",
            "陰午後短暫雷陣雨"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/22.svg'>";
              break;
            case ("多雲局部陣雨或雪",
            "多雲時陰有雨或雪",
            "多雲時陰短暫雨或雪",
            "多雲短暫雨或雪",
            "陰有雨或雪",
            "陰時多雲有雨或雪",
            "陰時多雲短暫雨或雪",
            "陰短暫雨或雪",
            "多雲時陰有雪",
            "多雲時陰短暫雪",
            "多雲短暫雪",
            "陰有雪",
            "陰時多雲有雪",
            "陰時多雲短暫雪",
            "陰短暫雪",
            "有雨或雪",
            "有雨或短暫雪",
            "陰有雨或短暫雪",
            "陰時多雲有雨或短暫雪",
            "多雲時陰有雨或短暫雪",
            "多雲有雨或短暫雪",
            "多雲有雨或雪",
            "多雲時晴有雨或雪",
            "晴時多雲有雨或雪",
            "晴有雨或雪",
            "短暫雨或雪",
            "多雲時晴短暫雨或雪",
            "晴時多雲短暫雨或雪",
            "晴短暫雨或雪",
            "有雪",
            "多雲有雪",
            "多雲時晴有雪",
            "晴時多雲有雪",
            "晴有雪",
            "短暫雪",
            "多雲時晴短暫雪",
            "晴時多雲短暫雪",
            "晴短暫雪"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/23.svg'>";
              break;
            case ("晴有霧", "晴晨霧"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/24.svg'>";
              break;
            case ("晴時多雲有霧", "晴時多雲晨霧"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/25.svg'>";
              break;
            case ("多雲時晴有霧", "多雲時晴晨霧"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/26.svg'>";
              break;
            case ("多雲有霧", "多雲晨霧", "有霧", "晨霧"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/27.svg'>";
              break;
            case ("陰有霧",
            "陰晨霧",
            "多雲時陰有霧",
            "多雲時陰晨霧",
            "陰時多雲有霧",
            "陰時多雲晨霧"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/28.svg'>";
              break;
            case ("多雲局部雨",
            "多雲局部陣雨",
            "多雲局部短暫雨",
            "多雲局部短暫陣雨"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/29.svg'>";
              break;
            case ("多雲時陰局部雨",
            "多雲時陰局部陣雨",
            "多雲時陰局部短暫雨",
            "多雲時陰局部短暫陣雨",
            "晴午後陰局部雨",
            "晴午後陰局部陣雨",
            "晴午後陰局部短暫雨",
            "晴午後陰局部短暫陣雨",
            "陰局部雨",
            "陰局部陣雨",
            "陰局部短暫雨",
            "陰局部短暫陣雨",
            "陰時多雲局部雨",
            "陰時多雲局部陣雨",
            "陰時多雲局部短暫雨",
            "陰時多雲局部短暫陣雨"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/30.svg'>";
              break;
            case ("多雲有霧有局部雨",
            "多雲有霧有局部陣雨",
            "多雲有霧有局部短暫雨",
            "多雲有霧有局部短暫陣雨",
            "多雲有霧有陣雨",
            "多雲有霧有短暫雨",
            "多雲有霧有短暫陣雨",
            "多雲局部雨有霧",
            "多雲局部雨晨霧",
            "多雲局部陣雨有霧",
            "多雲局部陣雨晨霧",
            "多雲局部短暫雨有霧",
            "多雲局部短暫雨晨霧",
            "多雲局部短暫陣雨有霧",
            "多雲局部短暫陣雨晨霧",
            "多雲陣雨有霧",
            "多雲短暫雨有霧",
            "多雲短暫雨晨霧",
            "多雲短暫陣雨有霧",
            "多雲短暫陣雨晨霧",
            "有霧有短暫雨",
            "有霧有短暫陣雨"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/31.svg'>";
              break;
            case ("多雲時陰有霧有局部雨",
            "多雲時陰有霧有局部陣雨",
            "多雲時陰有霧有局部短暫雨",
            "多雲時陰有霧有局部短暫陣雨",
            "多雲時陰有霧有陣雨",
            "多雲時陰有霧有短暫雨",
            "多雲時陰有霧有短暫陣雨",
            "多雲時陰局部雨有霧",
            "多雲時陰局部陣雨有霧",
            "多雲時陰局部短暫雨有霧",
            "多雲時陰局部短暫陣雨有霧",
            "多雲時陰陣雨有霧",
            "多雲時陰短暫雨有霧",
            "多雲時陰短暫雨晨霧",
            "多雲時陰短暫陣雨有霧",
            "多雲時陰短暫陣雨晨霧",
            "陰有霧有陣雨",
            "陰局部雨有霧",
            "陰局部陣雨有霧",
            "陰局部短暫陣雨有霧",
            "陰時多雲有霧有局部雨",
            "陰時多雲有霧有局部陣雨",
            "陰時多雲有霧有局部短暫雨",
            "陰時多雲有霧有局部短暫陣雨",
            "陰時多雲有霧有陣雨",
            "陰時多雲有霧有短暫雨",
            "陰時多雲有霧有短暫陣雨",
            "陰時多雲局部雨有霧",
            "陰時多雲局部陣雨有霧",
            "陰時多雲局部短暫雨有霧",
            "陰時多雲局部短暫陣雨有霧",
            "陰時多雲陣雨有霧",
            "陰時多雲短暫雨有霧",
            "陰時多雲短暫雨晨霧",
            "陰時多雲短暫陣雨有霧",
            "陰時多雲短暫陣雨晨霧",
            "陰陣雨有霧",
            "陰短暫雨有霧",
            "陰短暫雨晨霧",
            "陰短暫陣雨有霧",
            "陰短暫陣雨晨霧"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/32.svg'>";
              break;
            case ("多雲局部陣雨或雷雨",
            "多雲局部短暫陣雨或雷雨",
            "多雲局部短暫雷陣雨",
            "多雲局部雷陣雨"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/33.svg'>";
              break;
            case ("多雲時陰局部陣雨或雷雨",
            "多雲時陰局部短暫陣雨或雷雨",
            "多雲時陰局部短暫雷陣雨",
            "多雲時陰局部雷陣雨",
            "晴午後陰局部陣雨或雷雨",
            "晴午後陰局部短暫陣雨或雷雨",
            "晴午後陰局部短暫雷陣雨",
            "晴午後陰局部雷陣雨",
            "陰局部陣雨或雷雨",
            "陰局部短暫陣雨或雷雨",
            "陰局部短暫雷陣雨",
            "陰局部雷陣雨",
            "陰時多雲局部陣雨或雷雨",
            "陰時多雲局部短暫陣雨或雷雨",
            "陰時多雲局部短暫雷陣雨",
            "陰時多雲局部雷陣雨"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/34.svg'>";
              break;
            case ("多雲有陣雨或雷雨有霧",
            "多雲有雷陣雨有霧",
            "多雲有霧有陣雨或雷雨",
            "多雲有霧有雷陣雨",
            "多雲局部陣雨或雷雨有霧",
            "多雲局部短暫陣雨或雷雨有霧",
            "多雲局部短暫雷陣雨有霧",
            "多雲局部雷陣雨有霧",
            "多雲陣雨或雷雨有霧",
            "多雲短暫陣雨或雷雨有霧",
            "多雲短暫雷陣雨有霧",
            "多雲雷陣雨有霧",
            "多雲時晴短暫陣雨或雷雨有霧"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/35.svg'>";
              break;
            case ("多雲時陰有陣雨或雷雨有霧",
            "多雲時陰有雷陣雨有霧",
            "多雲時陰有霧有陣雨或雷雨",
            "多雲時陰有霧有雷陣雨",
            "多雲時陰局部陣雨或雷雨",
            "有霧",
            "多雲時陰局部短暫陣雨或雷雨有霧",
            "多雲時陰局部短暫雷陣雨有霧",
            "多雲時陰局部雷陣雨有霧",
            "多雲時陰陣雨或雷雨有霧",
            "多雲時陰短暫陣雨或雷雨有霧",
            "多雲時陰短暫雷陣雨有霧",
            "多雲時陰雷陣雨有霧",
            "陰局部陣雨或雷雨有霧",
            "陰局部短暫陣雨或雷雨有霧",
            "陰局部短暫雷陣雨有霧",
            "陰局部雷陣雨有霧",
            "陰時多雲有陣雨或雷雨有霧",
            "陰時多雲有雷陣雨有霧",
            "陰時多雲有霧有陣雨或雷雨",
            "陰時多雲有霧有雷陣雨",
            "陰時多雲局部陣雨或雷雨有霧",
            "陰時多雲局部短暫陣雨或雷雨有霧",
            "陰時多雲局部短暫雷陣雨有霧",
            "陰時多雲局部雷陣雨有霧",
            "陰時多雲陣雨或雷雨有霧",
            "陰時多雲短暫陣雨或雷雨有霧",
            "陰時多雲短暫雷陣雨有霧",
            "陰時多雲雷陣雨有霧",
            "陰短暫陣雨或雷雨有霧",
            "陰短暫雷陣雨有霧",
            "雷陣雨有霧"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/36.svg'>";
              break;
            case ("多雲局部雨或雪有霧",
            "多雲時陰局部雨或雪有霧",
            "陰時多雲局部雨或雪有霧",
            "陰局部雨或雪有霧",
            "短暫雨或雪有霧",
            "有雨或雪有霧"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/37.svg'>";
              break;
            case ("短暫陣雨有霧", "短暫陣雨晨霧", "短暫雨有霧", "短暫雨晨霧"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/38.svg'>";
              break;
            case ("有雨有霧", "陣雨有霧"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/39.svg'>";
              break;
            case ("短暫陣雨或雷雨有霧", "陣雨或雷雨有霧"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/41.svg'>";
              break;
            case ("下雪", "積冰", "暴風雪"):
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/42.svg'>";
              break;
            default:
              var hs =
                "<img src='	https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/40.svg'>";
              break;
          }
          sc +=
            "<div class='col' style='border-radius: 20%; background-color: #fff;margin: 5px'>" +
            "<div>" +
            hs +
            cc[6].time[i].startTime.split(" ")[0] +
            "</div>" +
            "<div>" +
            cc[6].time[i].elementValue[0].value +
            "</div>" +
            "<div>平均溫度:" +
            cc[1].time[i].elementValue[0].value +
            "</div>" +
            "<div>風向:" +
            cc[13].time[i].elementValue[0].value +
            "</div>" +
            "<div></div>" +
            "<div></div>" +
            "</div>";

          i++;
        }
        $(".wearherTitle").html(sc);
      }
    </script>
  </body>
</html>
