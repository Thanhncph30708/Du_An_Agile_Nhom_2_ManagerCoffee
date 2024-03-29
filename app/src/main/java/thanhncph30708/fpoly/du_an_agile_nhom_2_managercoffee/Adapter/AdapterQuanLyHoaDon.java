package thanhncph30708.fpoly.du_an_agile_nhom_2_managercoffee.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import thanhncph30708.fpoly.du_an_agile_nhom_2_managercoffee.DAO.KhachHangDAO;
import thanhncph30708.fpoly.du_an_agile_nhom_2_managercoffee.DAO.NhanVienDAO;
import thanhncph30708.fpoly.du_an_agile_nhom_2_managercoffee.DTO.HoaDon;
import thanhncph30708.fpoly.du_an_agile_nhom_2_managercoffee.DTO.KhachHang;
import thanhncph30708.fpoly.du_an_agile_nhom_2_managercoffee.DTO.NhanVien;
import thanhncph30708.fpoly.du_an_agile_nhom_2_managercoffee.Fragment.DoanhThuFragment;
import thanhncph30708.fpoly.du_an_agile_nhom_2_managercoffee.Fragment.QuanLyHoaDonFragment;
import thanhncph30708.fpoly.du_an_agile_nhom_2_managercoffee.R;


public class AdapterQuanLyHoaDon extends ArrayAdapter {
    private Context context;
    QuanLyHoaDonFragment fragment;
    //
    private ArrayList<HoaDon> list;
    TextView tvMaHD , tvNhanVien , tvKhachHang , tvTongTien , tvNgayXuat , tvTrangThai;
    ImageView img;
    DoanhThuFragment doanhThuFragment;
    public AdapterQuanLyHoaDon(@NonNull Context context, QuanLyHoaDonFragment fragment, ArrayList<HoaDon> list) {
        super(context, 0 , list);
        this.context = context;
        this.list =list;
        this.fragment = fragment;
    }
    public AdapterQuanLyHoaDon(@NonNull Context context, DoanhThuFragment fragment, ArrayList<HoaDon> list) {
        super(context, 0 , list);
        this.context = context;
        this.list =list;
        this.doanhThuFragment = fragment;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.layout_item_hoa_don, null);
        }
        final HoaDon item = list.get(position);
        if(view!= null){
            tvMaHD = view.findViewById(R.id.tvMaHD);
            tvNhanVien = view.findViewById(R.id.tvNhanVien);
            tvKhachHang = view.findViewById(R.id.tvKhachHang);
            tvTongTien = view.findViewById(R.id.tvTongTien);
            tvNgayXuat = view.findViewById(R.id.tvNgayXuat);
            tvTrangThai = view.findViewById(R.id.tvTrangThai);

            tvMaHD.setText("Mã hóa đơn: " + item.getMaHD());

            NhanVienDAO nhanVienDAO = new NhanVienDAO(context);
            NhanVien nv = nhanVienDAO.getID(String.valueOf(item.getMaNV()));
            tvNhanVien.setText("Tên nhân viên: " + nv.getHoTen());
            //
            KhachHangDAO khachHangDAO = new KhachHangDAO(context);
            KhachHang kh = khachHangDAO.getID(String.valueOf(item.getMaKH()));
            tvKhachHang.setText("Tên khách hàng: " + kh.getHoTen());

            DecimalFormat decimalFormat = new DecimalFormat("###,###.###");
            tvTongTien.setText("Tổng tiền: " + decimalFormat.format(item.getTongTien())+" VND");

            tvNgayXuat.setText("Ngày xuất: " + sdf.format(item.getNgayXuat()) );

            if(item.getTrangThai() == 1){
                tvTrangThai.setText("Đã thanh toán");
                tvTrangThai.setTextColor(Color.BLUE);
            }else{
                tvTrangThai.setText("Chưa thanh toán");
                tvTrangThai.setTextColor(Color.RED);
            }


        }

        return view;
    }
}
