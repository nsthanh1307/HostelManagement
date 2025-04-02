<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi" id="top">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Favicon -->
    <link rel="icon" href="./assets/images/favicon/favicon.png" type="image/x-icon" />

    <!-- Title -->
    <title>Trang chủ</title>

    <!-- Bootstrap 5.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <!-- Vendor CSS Files -->
    <link href="./assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="./assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
    <link href="./assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
    <link href="./assets/vendor/aos/aos.css" rel="stylesheet">

    <!-- Core CSS -->
    <link rel="stylesheet" href="./assets/css/core_style/core.css">

    <!-- AOS JS -->
    <link rel="stylesheet" href="./assets/js/aos_js/dist/aos.css">
    <script src="./assets/js/aos_js/dist/aos.js"></script>

    <!-- Link your own CSS here -->
    <link rel="stylesheet" href="./assets/css/system_style/home_style/home.css">
    <link rel="stylesheet" href="./assets/css/system_style/home_style/home2.css">
</head>

<body class="position-relative over-flow-hidden">
<!-- Preloader -->
<div id="preloader">
    <div class="dots">
        <div></div>
        <div></div>
        <div></div>
    </div>
</div>
<!-- End Preloader -->

<!-- Navbar -->
<div class="home-navbar">
    <div class="container navbar-pc">
        <div class="row">
            <div class="col-3">
                <!-- Logo -->
                <div class="home-navbar__logo">
                    <a href="#top" class="home-navbar__logo-link">
                        <img class="home-navbar__logo-img" src="./assets/images/logos/logo.png" alt="Logo">
                    </a>
                </div>
            </div>
            <div class="col-9">
                <!-- Actions -->
                <div class="home-navbar__actions">
                    <div id="" class="home-navbar__links">
                        <div class="home-navbar__actions-group">
                            <a href="#hostel-owner"
                               class="home-navbar__actions-link home-navbar__actions-link--owner">
                                Chủ trọ
                            </a>
                        </div>

                        <div class="home-navbar__actions-group">
                            <a href="#renter"
                               class="home-navbar__actions-link home-navbar__actions-link--renter">
                                Người thuê
                            </a>
                        </div>

                        <div class="home-navbar__actions-group">
                            <a href="#about" class="home-navbar__actions-link home-navbar__actions-link--renter">
                                Về chúng tôi
                            </a>
                        </div>

                        <div class="home-navbar__actions-group">
                            <a href="loginPage"
                               class="home-navbar__actions-link home-navbar__actions-link--login">
                                Đăng nhập
                            </a>
                        </div>

                        <div class="home-navbar__actions-group">
                            <button class="home-navbar__actions-link home-navbar__actions-link--register">
                                Đăng ký
                                <div class="register-modal">
                                    <a href="registerPage" class="register-owner">Chủ trọ</a>
                                    <a href="renter-register-page" class="register-renter">Người thuê</a>
                                </div>
                            </button>
                        </div>
                    </div>
                    <div id="home-navbar__mobile-btn" class="home-navbar__mobile-btn">
                        <i class="fa-solid fa-bars"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Menu mobile -->
    <div id="navbar-mobile" class="container navbar-mobile">
        <div class="navbar-mobile-group">
            <div class="navbar-mobile-group-header">Đăng ký</div>
            <a href="registerPage" class="navbar-mobile-link navbar-mobile-link--owner">Chủ trọ</a>
            <a href="#" class="navbar-mobile-link navbar-mobile-link--renter">Người thuê</a>
        </div>
        <div class="navbar-mobile-group">
            <a href="loginPage" class="navbar-mobile-link navbar-mobile-link--login">Đăng nhập</a>
        </div>
    </div>
</div>
<!-- End Navbar -->

<!-- Breadcrumbs -->
<div class="breadcrumbs">
    <div class="page-header d-flex align-items-center"
         style="background-image: url('./assets/images/system/page-header.jpg');">
        <div class="container position-relative">
            <div class="row d-flex justify-content-center">
                <div class="col-lg-6 text-center">
                    <h2>Hệ Thống Quản Lí Trọ</h2>
                    <h3 class="mt-4 mb-4" style="color: rgba(255, 255, 255, 0.8);">
                        Tự hào là doanh nghiệp hàng đầu trong tư vấn, nghiên cứu và phát triển các giải
                        pháp cho doanh nghiệp. Chúng tôi tự tin có thể mang đến cho bạn một bộ phần mềm quản lý nhà
                        trọ hoàn toàn giống như chúng tôi đã quảng cáo.
                    </h3>
                    <p>
                        Chúng tôi tự tin để đưa ra điều khoản hoàn tiền 100% trong vòng 30 ngày và không có bất kì
                        một câu hỏi nào thêm.
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Breadcrumbs -->

<!-- Banner -->
<div id="hostel-owner" class="banner banner-hostel-owner-wrapper">
    <div class="container">
        <div class="row">
            <div class="col-12 col-lg-6">
                <div class="banner-left">
                    <div class="banner-title" data-aos="fade-right" data-aos-duration="1000">
                        Quản lý toàn bộ khu trọ và phòng trọ ở cùng một nơi
                    </div>
                    <div class="banner-subtitle" data-aos="fade-right" data-aos-duration="1500">
                        Là một nền tảng cung cấp giải pháp quản lý thuận tiện, thông minh,...
                    </div>
                    <a href="registerPage" class="banner-link mb-5 mb-lg-9" data-aos="fade-up"
                       data-aos-duration="2000">
                        Trở thành chủ nhà Ngay
                    </a>
                </div>
            </div>
            <div class="col-12 col-lg-6">
                <div class="banner-right">
                    <img src="./assets/images/banners/hostel-1.png" alt="Hostel owner banner" class="banner-image"
                         data-aos="flip-down" data-aos-duration="2000">
                </div>
            </div>
        </div>
    </div>
</div>
<div id="renter" class="banner banner-renter-wrapper">
    <div class="bg-holder" style="background-image: url('./assets/images/background/shape.png');"></div>
    <div class="container">
        <div class="row">
            <div class="col-12 col-lg-6">
                <div class="banner-right">
                    <img src="./assets/images/banners/hostel-2.png" alt="Hostel owner banner" class="banner-image"
                         data-aos="flip-up" data-aos-duration="1500">
                </div>
            </div>
            <div class="col-12 col-lg-6">
                <div class="banner-left">

                    <div class="banner-title mt-5 mt-lg-0" data-aos="fade-down-left" data-aos-duration="1500">
                        Kết nối với chủ nhà nhanh chóng và phản hồi sự cố kịp thời
                    </div>
                    <div class="banner-subtitle" data-aos="zoom-in" data-aos-duration="1000">
                        Là một nền tảng cho phép người thuê dễ dàng kết nối với
                        chủ trọ, xem thông tin và hàng loạt tính năng mới
                    </div>
                    <a href="renter-register-page" class="banner-link renter-link" data-aos="fade-up" data-aos-duration="1000">
                        Trở thành người thuê Ngay
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- #main -->
<main id="main">
    <!-- ======= About Us Section ======= -->
    <section id="about" class="about">
        <div class="container" data-aos="fade-up">
            <div class="row gy-4">
                <div class="col-lg-6 position-relative align-self-start order-lg-last order-first">
                    <img src="./assets/images/system/about.jpg" class="img-fluid" alt="About Team Image">
                    <a href="https://www.youtube.com/watch?v=BC6KDzKHKD8" class="glightbox play-btn"></a>
                </div>
                <div class="col-lg-6 content order-last  order-lg-first">
                    <h3>Về chúng tôi</h3>
                    <p class="mt-5">
                        Công ty có 1 năm kinh nghiệm trong phát triển phần mềm cho thị trường Việt Nam.
                        35+ dự án phần mềm quản lý bất động sản, căn hộ cho thuê, nhà trọ từ các tập đoàn BĐS đến
                        các cá nhân chuyên viên.
                        Đội ngũ kết hợp giữa kinh nghiệm và sức trẻ, tham vọng và cái tâm với nghề.
                    </p>
                    <ul>
                        <li data-aos="fade-up" data-aos-delay="100">
                            <i class="bi bi-diagram-3"></i>
                            <div>
                                <h5>Tích hợp mọi thứ trong 1 ứng dụng</h5>
                                <p>
                                    Quản lý cả phòng trọ, thống kê tài chính, ghi điện nước thao tác cực dễ
                                </p>
                            </div>
                        </li>
                        <li data-aos="fade-up" data-aos-delay="200">
                            <i class="bi bi-fullscreen-exit"></i>
                            <div>
                                <h5>Tiện lợi, nhanh chóng và hiệu quả</h5>
                                <p>
                                    Phần mềm quản lý trọ này giúp tối giản 80% công việc của bạn
                                </p>
                            </div>
                        </li>
                        <li data-aos="fade-up" data-aos-delay="300">
                            <i class="bi bi-broadcast"></i>
                            <div>
                                <h5>Tính năng phần mềm quản lý nhà trọ</h5>
                                <p>
                                    Không giới hạn phòng cho thuê, ghi điện tiện lợi, quản lý nhiều khu trọ ở nhiều
                                    vị trí, thông báo thu tiền hằng tháng, ...
                                </p>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </section>
    <!-- End About Us Section -->

    <!-- ======= Stats Counter Section ======= -->
    <section id="stats-counter" class="stats-counter pt-0">
        <div class="container" data-aos="fade-up">

            <div class="row gy-4">
                <div class="col-lg-3 col-md-6">
                    <div class="stats-item text-center w-100 h-100">
                            <span data-purecounter-start="0" data-purecounter-end="232" data-purecounter-duration="1"
                                  class="purecounter"></span>
                        <p>Khách hàng</p>
                    </div>
                </div>
                <!-- End Stats Item -->

                <div class="col-lg-3 col-md-6">
                    <div class="stats-item text-center w-100 h-100">
                            <span data-purecounter-start="0" data-purecounter-end="1" data-purecounter-duration="1"
                                  class="purecounter"></span>
                        <p>Dự án</p>
                    </div>
                </div>
                <!-- End Stats Item -->

                <div class="col-lg-3 col-md-6">
                    <div class="stats-item text-center w-100 h-100">
                            <span data-purecounter-start="0" data-purecounter-end="1453" data-purecounter-duration="1"
                                  class="purecounter"></span>
                        <p>Số giờ hỗ trợ</p>
                    </div>
                </div>
                <!-- End Stats Item -->

                <div class="col-lg-3 col-md-6">
                    <div class="stats-item text-center w-100 h-100">
                            <span data-purecounter-start="0" data-purecounter-end="5" data-purecounter-duration="1"
                                  class="purecounter"></span>
                        <p>Nhân viên</p>
                    </div>
                </div>
                <!-- End Stats Item -->

            </div>

        </div>
    </section>
    <!-- End Stats Counter Section -->

    <!-- ======= Our Team Section ======= -->
    <section id="team" class="team pt-0">
        <div class="container" data-aos="fade-up">

            <div class="section-header">
                <span>Đội ngũ chúng tôi</span>
                <h2>Đội ngũ chúng tôi</h2>
            </div>

            <div class="row" data-aos="fade-up" data-aos-delay="100">
                <div class="col-lg-2 col-md-6 d-flex m-auto">
                    <div class="member">
                        <img src="https://avatars.githubusercontent.com/u/77594830?v=4" class="img-fluid" alt="">
                        <div class="member-content">
                            <h4>Nguyễn Sinh Thành</h4>
                            <span>Web Development</span>
                            <p>
                                Xin chào, tôi tên là Thành! Rất hân hạnh được làm việc với mọi người!
                            </p>
                            <div class="social">
                                <a href="https://www.facebook.com/Mr.kennnnn" target="_blank"><i
                                        class="bi bi-facebook"></i></a>
                                <a href="https://www.instagram.com/st13.7" target="_blank"><i
                                        class="bi bi-instagram"></i></a>
                                <a href="https://github.com/NST13july" target="_blank"><i
                                        class="bi bi-github"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </section>

    <!-- ======= Testimonials Section ======= -->
    <section id="testimonials" class="testimonials">
        <div class="container">

            <div class="slides-1 swiper" data-aos="fade-up">
                <div class="swiper-wrapper">
                    <div class="swiper-slide">
                        <div class="testimonial-item">
                            <img src="./assets/images/testimonials/testimonials-1.jpg" class="testimonial-img"
                                 alt="">
                            <h3>Anh Hải</h3>
                            <h4>Quản lý 100 phòng trọ</h4>
                            <div class="stars">
                                <i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i
                                    class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i
                                    class="bi bi-star-fill"></i>
                            </div>
                            <p>
                                <i class="bi bi-quote quote-icon-left"></i>
                                Trước đây việc quản lý của tôi cần thêm 2 nhân viên để phụ trách. Giờ đây mình tôi
                                có thể làm tất cả với phần mềm quản lý nhà trọ. Hiện tại tôi thoải mái làm những
                                việc khác. Cám ơn Hostel Management!
                                <i class="bi bi-quote quote-icon-right"></i>
                            </p>
                        </div>
                    </div>
                    <!-- End testimonial item -->

                    <div class="swiper-slide">
                        <div class="testimonial-item">
                            <img src="./assets/images/testimonials/testimonials-2.jpg" class="testimonial-img"
                                 alt="">
                            <h3>Chị Phượng</h3>
                            <h4>Quản lý 30 phòng trọ</h4>
                            <div class="stars">
                                <i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i
                                    class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i
                                    class="bi bi-star-fill"></i>
                            </div>
                            <p>
                                <i class="bi bi-quote quote-icon-left"></i>
                                Tôi không rành về máy móc, công nghệ. Nhưng tôi dễ dàng ứng dụng quản lý trọ
                                Hostel Management này. Thật sự dễ nhìn và dễ quản lý cho bất cứ ai! Tôi thật sự rất
                                hài lòng và đã đăng ký gói Timelife để tiết kiệm lâu dài.
                                <i class="bi bi-quote quote-icon-right"></i>
                            </p>
                        </div>
                    </div>
                    <!-- End testimonial item -->

                    <div class="swiper-slide">
                        <div class="testimonial-item">
                            <img src="./assets/images/testimonials/testimonials-4.jpg" class="testimonial-img"
                                 alt="">
                            <h3>Anh Thịnh</h3>
                            <h4>Quản lý chung cư mini</h4>
                            <div class="stars">
                                <i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i
                                    class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i
                                    class="bi bi-star-fill"></i>
                            </div>
                            <p>
                                <i class="bi bi-quote quote-icon-left"></i>
                                Lúc đầu tôi chỉ dùng thử vì tò mò. Nhưng khi thấy được sự tiện lợi về cách quản lý
                                cũng như có thể giám sát ngay trên điện thoại. Tôi đã đăng ký ngay 5 năm để sử dụng.
                                <i class="bi bi-quote quote-icon-right"></i>
                            </p>
                        </div>
                    </div>
                    <!-- End testimonial item -->

                    <div class="swiper-slide">
                        <div class="testimonial-item">
                            <img src="./assets/images/testimonials/testimonials-3.jpg" class="testimonial-img"
                                 alt="">
                            <h3>Chị Hà</h3>
                            <h4>Quản lý chuỗi BĐS cho thuê</h4>
                            <div class="stars">
                                <i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i
                                    class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i
                                    class="bi bi-star-fill"></i>
                            </div>
                            <p>
                                <i class="bi bi-quote quote-icon-left"></i>
                                Số lượng lớn BĐS cho thuê khiến tôi làm việc liên tục và không có thời gian nghỉ
                                ngơi. Nhờ Hostel Management mà giờ đây tôi tự tin tăng số lượng bất động sản cho
                                thuê và làm chủ thời gian của mình!
                                <i class="bi bi-quote quote-icon-right"></i>
                            </p>
                        </div>
                    </div>
                    <!-- End testimonial item -->

                    <div class="swiper-slide">
                        <div class="testimonial-item">
                            <img src="./assets/images/testimonials/testimonials-5.jpg" class="testimonial-img"
                                 alt="">
                            <h3>Anh Tùng</h3>
                            <h4>Quản lý chuỗi nhà trọ</h4>
                            <div class="stars">
                                <i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i
                                    class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i
                                    class="bi bi-star-fill"></i>
                            </div>
                            <p>
                                <i class="bi bi-quote quote-icon-left"></i>
                                Hình ảnh vỗ cùng trực quan và dễ quản lý. Tôi rất hài lòng với tính năng ghi tiền
                                điện nước bằng hình ảnh. Tôi đã không còn phải sử dụng giấy bút và excel phức tạp để
                                quản lý nữa. Một phần mềm hoàn hảo!
                                <i class="bi bi-quote quote-icon-right"></i>
                            </p>
                        </div>
                    </div>
                    <!-- End testimonial item -->
                </div>
                <div class="swiper-pagination"></div>
            </div>
        </div>
    </section>
    <!-- End Testimonials Section -->

    <!-- ======= Frequently Asked Questions Section ======= -->
    <section id="faq" class="faq">
        <div class="container" data-aos="fade-up">

            <div class="section-header">
                <span>Các câu hỏi thường gặp</span>
                <h2>Các câu hỏi thường gặp</h2>

            </div>

            <div class="row justify-content-center" data-aos="fade-up" data-aos-delay="200">
                <div class="col-lg-10">

                    <div class="accordion accordion-flush" id="faqlist">

                        <div class="accordion-item">
                            <h3 class="accordion-header">
                                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                        data-bs-target="#faq-content-1">
                                    <i class="bi bi-question-circle question-icon"></i>
                                    Phần mềm quản lý nhà trọ có tương tác được với người thuê nhà không?
                                </button>
                            </h3>
                            <div id="faq-content-1" class="accordion-collapse collapse" data-bs-parent="#faqlist">
                                <div class="accordion-body">
                                    Với phần mềm quản lý khách thuê Hostel Management bạn sẽ dễ dàng quản lý và
                                    tương tác với khách hàng ngay trên app. Dễ dàng thông báo tiền tháng và giao
                                    tiếp khách bằng tin nhắn ngay trên App.
                                </div>
                            </div>
                        </div>
                        <!-- # Faq item-->

                        <div class="accordion-item">
                            <h3 class="accordion-header">
                                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                        data-bs-target="#faq-content-2">
                                    <i class="bi bi-question-circle question-icon"></i>
                                    Tôi quản lý nhiều nhà trọ ở nhiều khu vực cần sử dụng mấy tài khoản trên APP
                                    quản lý trọ này?
                                </button>
                            </h3>
                            <div id="faq-content-2" class="accordion-collapse collapse" data-bs-parent="#faqlist">
                                <div class="accordion-body">
                                    Chỉ với 1 tài khoản và 1 gói đăng ký duy nhất, bạn có thể dễ dàng quản lý số
                                    lượng phòng theo gói mà bạn đang ký, không phân biệt khu vực địa lý.
                                </div>
                            </div>
                        </div>
                        <!-- # Faq item-->

                        <div class="accordion-item">
                            <h3 class="accordion-header">
                                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                        data-bs-target="#faq-content-3">
                                    <i class="bi bi-question-circle question-icon"></i>
                                    Nếu bảng giá phần mềm quản lý nhà cho thuê thay đổi tôi có phải trả thêm tiền
                                    không?
                                </button>
                            </h3>
                            <div id="faq-content-3" class="accordion-collapse collapse" data-bs-parent="#faqlist">
                                <div class="accordion-body">
                                    Bạn chỉ phải trả tiền cho gói mà bạn đăng ký trong lần đầu tiên. Mọi nâng cấp và
                                    cải tiến từ phần mềm bạn sẽ không phải chịu thêm chi phí nào khác.
                                </div>
                            </div>
                        </div>
                        <!-- # Faq item-->
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- End Frequently Asked Questions Section -->
</main>
<!-- End #main -->

<!-- Footer -->
<footer>
    <div class="container">
        <div class="row wrapper">
            <div class="col-12 mb-5">
                <div class="row">
                    <div class="col-6 col-md-3">
                        <div class="footer-header">
                            <img class="footer-logo" src="./assets/images/logos/logo.png" alt="Logo">
                        </div>
                    </div>
                    <div class="col-6 col-md-3">
                        <div class="footer-header">Đường dẫn nhanh</div>
                        <ul class="footer-list">
                            <li class="footer-item"><a href="#about" class="footer-link">Về chúng tôi</a></li>
                            <li class="footer-item"><a href="#faq" class="footer-link">FAQ</a></li>
                        </ul>
                    </div>
                    <div class="col-6 col-md-3">
                        <div class="footer-header">Hỗ trợ</div>
                        <ul class="footer-list">
                            <li class="footer-item">
                                <a href="https://slack.com/" class="footer-link" target="_blank">
                                    Cộng đồng Slack
                                </a>
                            </li>
                            <li class="footer-item"><a class="footer-link">Tài liệu hỗ trợ</a></li>
                        </ul>
                    </div>
                    <div class="col-6 col-md-3">
                        <div class="footer-header">Liên hệ</div>
                        <ul class="footer-list">
                            <li class="footer-item">nsthanh1307@gmail.com</li>
                            <li class="footer-item">+84 962223714</li>
                            <li class="footer-item footer-socials">
                                <a href="https://www.facebook.com/Mr.kennnnn" target="_blank" class="footer-link">
                                    <i class="footer-icon fa-brands fa-facebook-square"></i>
                                </a>
                                <a href="https://github.com/NST13july" target="_blank" class="footer-link">
                                    <i class="footer-icon fa-brands fa-github-square"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-12">
                <div class="copyright-wrapper d-flex justify-content-center pt-5 pb-5">
                    <div class="copyright-content">© 2024 All rights reserved.</div>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- End Footer -->

<!-- Scroll Icon -->
<a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>
<!-- End Scroll Icon -->

<!-- Script Bootstrap !important -->
<script src="./assets/js/bootstrap/bootstrap.bundle.min.js"></script>
<!-- Jquery -->
<script src="./assets/js/jquery-3.5.1.min.js"></script>
<!-- Vendor JS Files -->
<script src="./assets/vendor/purecounter/purecounter_vanilla.js"></script>
<script src="./assets/vendor/glightbox/js/glightbox.min.js"></script>
<script src="./assets/vendor/swiper/swiper-bundle.min.js"></script>
<script src="./assets/vendor/aos/aos.js"></script>
<script src="./assets/vendor/php-email-form/validate.js"></script>
<!-- Link your script here -->
<script src="./assets/js/system/home-handle.js"></script>
<script src="./assets/js/system/home-handle-2.js"></script>
<!-- Loader -->
<script src="./assets/js/loading-handler.js"></script>
</body>

</html>