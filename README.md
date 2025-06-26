### 🧠 **Đặc điểm chính của watermark:**

* Là một phần **gắn liền** với nội dung (ảnh, video, tài liệu).
* **Không làm thay đổi nội dung chính** nhưng giúp nhận diện được **nguồn gốc** hoặc **người sở hữu**.
* Có thể **hiển thị rõ ràng** hoặc được **ẩn một cách khéo léo**.

## 🔍 **Phân loại watermark**

| Loại watermark                 | Mô tả ngắn gọn                                      | Ví dụ                                                       |
| ------------------------------ | --------------------------------------------------- | ----------------------------------------------------------- |
| ✅ **Watermark hiện (Visible)** | Dễ thấy bằng mắt thường. Có thể là chữ, logo mờ.    | Logo công ty ở giữa ảnh, chữ “CONFIDENTIAL” trong file PDF. |
| ✅ **Watermark ẩn (Invisible)** | Không thể nhìn thấy bằng mắt, dùng kỹ thuật mã hóa. | Mã nhúng vào ảnh, chỉ phát hiện bằng phần mềm chuyên dụng.  |

## 🎯 **Mục đích của watermark**

| Mục đích                    | Giải thích                                                        |
| --------------------------- | ----------------------------------------------------------------- |
| 🔒 **Bảo vệ bản quyền**     | Ngăn chặn sao chép, chỉnh sửa hoặc tái sử dụng mà không xin phép. |
| 👤 **Xác nhận sở hữu**      | Hiển thị ai là chủ sở hữu (logo, tên thương hiệu).                |
| 📢 **Quảng bá thương hiệu** | Giúp lan truyền tên tuổi khi nội dung được chia sẻ rộng rãi.      |
| 📜 **Xác thực tài liệu**    | Đảm bảo tài liệu là bản chính thức, không bị giả mạo.             |

## 🛠 **Ứng dụng của watermark**

| Lĩnh vực             | Ứng dụng cụ thể                                       |
| -------------------- | ----------------------------------------------------- |
| 📸 Nhiếp ảnh         | Gắn logo lên ảnh trước khi chia sẻ trên mạng.         |
| 🎥 Truyền hình/video | Logo kênh TV hoặc bản quyền video.                    |
| 📄 Văn phòng/PDF     | Gắn chữ "Draft", "Confidential", hoặc dấu công ty.    |
| 🔐 Bảo mật số        | Gắn thông tin nhận dạng ẩn để truy vết rò rỉ dữ liệu. |

## 📌 Ví dụ thực tế:

1. **YouTube video** có logo ở góc — để khẳng định chủ sở hữu video.
2. **Ảnh cưới của studio** có logo mờ ở giữa để tránh bị lấy cắp.
3. **Tài liệu bí mật PDF** có watermark mờ chữ “CONFIDENTIAL” chạy chéo trang.

## 🧑‍💻 Kỹ thuật watermark trong lập trình:

* Dùng `Graphics2D` để vẽ chữ hoặc logo mờ lên ảnh.
* Sử dụng các thuật toán như **LSB (Least Significant Bit)** để giấu watermark vào ảnh một cách không thể phát hiện bằng mắt thường.
* Trong video: chèn watermark bằng các thư viện như `FFmpeg`.

