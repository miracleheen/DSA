impl Solution {
    pub fn is_number(s: String) -> bool {
        let bytes = s.trim().as_bytes();
        if bytes.is_empty() {
            return false;
        }

        let mut i = 0;
        let n = bytes.len();

        fn scan_digits(bytes: &[u8], i: &mut usize) -> bool {
            let start = *i;
            while *i < bytes.len() && bytes[*i].is_ascii_digit() {
                *i += 1;
            }
            *i > start
        }

        // optional sign
        if i < n && (bytes[i] == b'+' || bytes[i] == b'-') {
            i += 1;
        }

        let mut has_digit = false;

        // digits before dot
        if i < n && bytes[i].is_ascii_digit() {
            has_digit = scan_digits(bytes, &mut i);
        }

        // fractional part
        if i < n && bytes[i] == b'.' {
            i += 1;
            let after_dot = if i < n && bytes[i].is_ascii_digit() {
                scan_digits(bytes, &mut i)
            } else {
                false
            };
            has_digit = has_digit || after_dot;
        }

        if !has_digit {
            return false;
        }

        // exponent part
        if i < n && (bytes[i] == b'e' || bytes[i] == b'E') {
            i += 1;

            if i < n && (bytes[i] == b'+' || bytes[i] == b'-') {
                i += 1;
            }

            if i >= n || !bytes[i].is_ascii_digit() {
                return false;
            }

            scan_digits(bytes, &mut i);
        }
        
        i == n
    }
}