# spring-validate-service
1 ứng dụng demo với springboot validation.

ứng dụng trong trường hợp, cùng với 1 api, 1 request body nhưng trường hợp `lưu và thoát` hoặc `tiếp tục` thì logic validate sẽ khác nhau

ví dụ: api `localhost:8083/order/save`
- Trường hợp 1. với request body:
```JSON
{
  "saveType": "SAVE_AND_EXIT",
  "name": "   ",
  "description": "example "
}
```
thì chỉ validate đối với trường `description`.
đây là response:
```JSON
{
    "message": "in_valid",
    "code": "bad_request",
    "details": [
        {
            "fieldName": "description",
            "message": "Invalid value"
        }
    ]
}
```
- Trường hợp 2. với request body:
```JSON
{
  "saveType": "SAVE_AND_CONTINUE",
  "name": "   ",
  "description": "example "
}
```

thì logic validate sẽ bắt buộc nhập trường `name`.
đây là response:
```JSON
{
    "message": "validated",
    "code": "badrequest",
    "details": [
        {
            "fieldName": "name",
            "message": "must not be blank"
        }
    ]
}
```


-> đã giải quyết được việc là vẫn sử dụng được các annotation của Spring validation, nhưng vẫn tuỷ chỉnh được theo từng trường hợp.

