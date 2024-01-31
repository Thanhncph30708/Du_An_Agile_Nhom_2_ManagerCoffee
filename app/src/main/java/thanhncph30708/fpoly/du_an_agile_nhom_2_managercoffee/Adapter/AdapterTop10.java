package thanhncph30708.fpoly.du_an_agile_nhom_2_managercoffee.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import thanhncph30708.fpoly.du_an_agile_nhom_2_managercoffee.DTO.Top10;
import thanhncph30708.fpoly.du_an_agile_nhom_2_managercoffee.Fragment.Top10Fragment;
import thanhncph30708.fpoly.du_an_agile_nhom_2_managercoffee.R;


public class AdapterTop10 extends ArrayAdapter<Top10> {
    private Context context;
    Top10Fragment fragment;
    private ArrayList<Top10> list;
    TextView tvDoUong, tvSL;


    public AdapterTop10(@NonNull Context context, Top10Fragment fragment, ArrayList<Top10> list) {
        super(context, 0, list);
        this.context = context;
        this.fragment = fragment;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view== null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.layout_item_top10, null);
        }
        final Top10 item = list.get(position);
        if (item != null){
            tvDoUong = view.findViewById(R.id.tvDoUong);
            tvSL = view.findViewById(R.id.tvSL);
            tvDoUong.setText("Tên đồ uống: "+item.tenDoUong);
            tvSL.setText("Số lượng: "+item.soLuong);
        }
        return view;
    }
}
