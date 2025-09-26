KHOA CÔNG NGHỆ THÔNG TIN BỘ MÔN CÔNG NGHỆ PHẦN MỀM![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.001.png)

LẬP TRÌNH WEB (WEBPR330479)![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.002.png)![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.003.png)![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.004.png)

GraphQL & RestFul API ![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.005.png)![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.006.png)![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.007.png)![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.008.png)![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.009.png)![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.010.png)![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.011.png)![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.012.png)![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.013.png)

trong Spring boot![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.014.png)

THS. NGUYỄN HỮU TRUNG

PR33 WEB![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.015.png)

0479

Giới thiệu GraphQL?

**2 ![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.016.jpeg)![ref1]**

**3![ref1]**

ThS. Nguyễn Hữu Trung  ![ref2]![ref3]
Giới thiệu GraphQL?

GraphQL![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.020.png)

Đặc trưng ![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.021.png)của GraphQL

https://graphql.org/

- Là ngôn ngữ thao tác và truy vấn dữ liệu nguồn mở cho API
- Cung cấp cách thức dễ dàng để request chính xác và vừa đủ.
- Được Facebook phát triển vào năm 2012.
- Cho phép client xác định chính xác những dữ liệu gì họ cần
- GraphQL làm cho việc tổng hợp dữ liệu từ nhiều nguồn dễ dàng hơn
- Sử dụng một type system để khai báo dữ liệu**VB**.

**LT![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.022.png)![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.023.png)**

ThS. Nguyễn Hữu Trung  ![ref2]![ref3]
Giới thiệu GraphQL?

**4![ref1]**

![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.024.jpeg)

**5![ref1]**

- **Trả về chính xác những gì bạn gửi request**
- Khi gửi 1 request GraphQL đến API, thì sẽ nhận được chính xác những gì được yêu cầu trong request, không hơn không kém.
- Các truy vấn GraphQL luôn trả về kết quả có thể dự đoán được.
- Các ứng dụng sử dụng GraphQL rất nhanh và ổn định vì GraphQL kiểm soát dữ liệu mà nó nhận được chứ không phải máy chủ.

**6![ref1]**

- **Nhận nhiều dữ liệu trong một request duy nhất**
- Các câu query GraphQL không chỉ có thể truy xuất các thuộc tính của một dữ liệu mà còn làm việc trơn tru với các đối tượng khác.
- GraphQL có thể lấy tất cả dữ liệu mà ứng dụng của bạn cần trong một request duy nhất.
- Các ứng dụng sử dụng GraphQL có tốc độ xử lý rất nhanh ngay cả trên các kết nối chậm (di động, IoTs).

  ![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.025.jpeg)

**7![ref1]**

ThS. Nguyễn Hữu Trung  ![ref2]![ref3]
Giới thiệu GraphQL?

- **Mô tả những gì có thể với một type system**
- API GraphQL được tổ chức theo **type** và **fields**, truy cập toàn bộ dữ liệu của bạn từ một **endpoint** duy nhất.
- GraphQL sử dụng các **types** để đảm bảo ứng dụng của bạn chỉ request những gì có thể, ngoài ra GraphQL còn giải thích các lỗi 1 cách rất dễ hiểu.
- Ứng dụng của bạn có thể sử dụng các **types** để tránh viết code phân tích cú pháp thủ công.

![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.026.jpeg)

ThS. Nguyễn Hữu Trung  ![ref2]![ref3]

Những điểm tương đồng giữa GraphQL và REST là gì?

**8![ref1]**

- REST và GraphQL cho phép bạn tạo, sửa đổi, cập nhật và xóa dữ liệu trên một ứng dụng, dịch vụ hoặc mô-đun riêng biệt thông qua API.
- Một máy khách gửi yêu cầu API đến một điểm cuối hoặc nhiều điểm cuối trên một máy chủ
- Máy chủ cung cấp phản hồi có chứa dữ liệu, trạng thái dữ liệu hoặc mã lỗi
- **Kiến trúc**: đều không có trạng thái, đều sử dụng mô hình máy khách – máy chủ.
- **Thiết kế dựa trên tài nguyên**: Ví dụ: hãy xem xét một API mạng xã hội nơi người dùng tạo và quản lý bài đăng. Trong API dựa trên tài nguyên, bài đăng sẽ là một tài nguyên. Nó có mã định danh duy nhất riêng, ví dụ: */posts/1234*. Đồng thời, nó có một tập hợp các thao tác, như ***GET*** để truy xuất bài đăng trong REST hoặc ***query*** (truy vấn) để truy xuất bài đăng trong GraphQL.

  **Trao đổi dữ liệu**: đều hỗ trợ các định dạng dữ liệu JSON, đều hỗ trợ khả năng ghi vào bộ nhớ đệm.

¨

- **Tính trung lập về ngôn ngữ và cơ sở dữ liệu:** Tính trung lập về ngôn ngữ và cơ sở dữ liệu**.**

ThS. Nguyễn Hữu Trung  ![ref2]![ref3]

GraphQL và REST khác nhau ở điểm nào?![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.027.png)

**9**

REST GraphQL


REST là một tập hợp các quy tắc định hình Đó là gì? quá trình trao đổi dữ liệu có cấu trúc giữa 

một máy khách và một máy chủ.

Trường hợp sử  REST phù hợp với các nguồn dữ liệu đơn dụng phù hợp  giản trong đó tài nguyên được xác định rõ nhất ràng.

Truy cập dữ  REST có nhiều điểm cuối dưới dạng URL để liệu xác định tài nguyên.

REST trả về dữ liệu theo một cấu trúc cố Dữ liệu trả về định do máy chủ xác định.

GraphQL là một ngôn ngữ truy vấn, kiểu kiến trúc và tập hợp các công cụ để tạo và thao tác với các API.

GraphQL phù hợp với các nguồn dữ liệu lớn, phức tạp và liên quan đến nhau.

GraphQL có một điểm cuối URL duy nhất.

GraphQL trả về dữ liệu theo một cấu trúc linh hoạt do máy khách xác định.


Cách dữ liệu  Dữ liệu REST định kiểu yếu. Vì vậy, máy  Dữ liệu GraphQL định kiểu mạnh. Vì vậy, máy được cấu trúc  khách phải quyết định cách diễn giải dữ liệu  khách nhận dữ liệu theo định dạng đã xác định và xác định đã định dạng khi dữ liệu được trả về. trước và cả hai bên cùng hiểu.

Với REST, khách hàng phải kiểm tra xem dữ  Với GraphQL, các yêu cầu không hợp lệ thường bị Kiểm tra lỗi liệu trả về có hợp lệ hay không. 200, 500,  cấu trúc lược đồ từ chối. Điều này làm xuất hiện 

401 một thông báo lỗi được tự động tạo. 200, error ![ref2]![ref3]ThS. Nguyễn Hữu Trung 


GraphQL cố gắng khắc phục những hạn chế nào của REST?

**11![ref1]**

- **Trao đổi dữ liệu có cấu trúc cố định**: API REST đòi hỏi các yêu cầu máy khách phải tuân theo một cấu trúc cố định để nhận tài nguyên. Cấu trúc cứng nhắc này rất dễ sử dụng, nhưng không phải lúc nào cũng là phương tiện hiệu quả nhất để trao đổi chính xác dữ liệu cần.
- **Lấy thừa dữ liệu và lấy thiếu dữ liệu**: API REST luôn trả về một tập dữ liệu toàn bộ. Ví dụ: từ một đối tượng *person* (người) trong API REST, sẽ nhận được tên, ngày sinh, địa chỉ và số điện thoại của người đó. Thì sẽ nhận được tất cả dữ liệu này ngay cả khi chỉ cần lấy số điện thoại. Tương tự, nếu muốn biết số điện thoại của một người và lần mua gần đây nhất, bạn sẽ cần nhiều yêu cầu API REST. URL */person* sẽ trả về số điện thoại và URL */purchase* sẽ trả về lịch sử mua hàng.

Thời điểm nên sử dụng GraphQL hay REST

**12![ref1]**

- Có thể sử dụng các API GraphQL và REST thay thế cho nhau. Tuy nhiên, trong một số trường hợp sẽ có một API phù hợp hơn API kia. Ví dụ: GraphQL có thể là lựa chọn tốt hơn nếu bạn có những cân nhắc sau:
- Bạn có băng thông giới hạn và bạn muốn giảm thiểu số lượng yêu cầu và phản hồi
- Bạn có nhiều nguồn dữ liệu và bạn muốn kết hợp chúng tại một điểm cuối
- Bạn có các yêu cầu máy khách có sự khác biệt đáng kể và bạn muốn có các phản hồi rất khác nhau

GraphQL và Rest trong Spring boot

**13![ref1]**

REST![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.028.jpeg)![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.029.png)![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.030.png)![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.031.png)

GRAPHQL![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.032.png)![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.033.jpeg)![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.034.png)![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.035.png)

ThS. Nguyễn Hữu Trung  ![ref2]![ref3]

**14![ref1]**

![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.036.jpeg) ThS. Nguyễn Hữu Trung ![ref2] ![ref3]![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.037.jpeg)


**15![ref1]**

![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.038.png)

![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.039.jpeg)

Tạo product

**16![](Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.040.jpeg)![ref1]**
ThS. Nguyễn Hữu Trung  ![ref2]![ref3]

[ref1]: Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.017.png
[ref2]: Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.018.png
[ref3]: Aspose.Words.6b17b81b-09ae-461f-a08e-ff363dad17dc.019.png
